package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.arreglo.ArregloCurso
import com.example.myapplication.clase.Alumno
import com.example.myapplication.utils.AppConfig
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AlumnoNuevoActivity:AppCompatActivity() {
    private lateinit var atvCursos:AutoCompleteTextView
    private lateinit var txtNombre:TextInputEditText
    private lateinit var txtPaterno:TextInputEditText
    private lateinit var txtMaterno:TextInputEditText
    private lateinit var btnGrabar:Button
    private lateinit var btnVolver:Button
    //variable para almacenar el acceso a la base de datos en firebase
    private lateinit var bd:DatabaseReference
    var curso:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alumno_nuevo_activity)
        atvCursos=findViewById(R.id.atvCursos)
        txtNombre=findViewById(R.id.edtNombresAlumno)
        txtPaterno=findViewById(R.id.edtPaternoAlumno)
        txtMaterno=findViewById(R.id.edtMaternoAlumno)
        btnGrabar=findViewById(R.id.btnGrabarAlumno)
        //btnVolver=findViewById(R.id.btnVolver)

        btnGrabar.setOnClickListener({insertarAlumno()})
//        btnVolver.setOnClickListener({volver()})


        cargarCursos()
        conectar()
        atvCursos.onItemClickListener=AdapterView.OnItemClickListener{
            parent,view,position,id->curso=position+1
        }
    }
    fun volver(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun insertarAlumno(){
        val nom:String;val pat:String;val mat:String;
        nom=txtNombre.text.toString()
        pat=txtPaterno.text.toString()
        mat=txtMaterno.text.toString()
        //generar clave
        val key=bd.push().key
        //crear objeto de la clase Alumno
        val bean=Alumno(0,nom,pat,mat,key!!,curso)
        //acceder a la base dato
        bd.child("alumno").child(key!!).setValue(bean).addOnCompleteListener {
            Toast.makeText(AppConfig.CONTEXTO,"Alumno registrado",Toast.LENGTH_LONG).show()
        }
    }
    fun cargarCursos(){
        val data=ArregloCurso().listado()
        var lista=ArrayList<String>()
        data.forEach{e->
            lista.add(e.nombre)
        }
        //crear adaptador
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        atvCursos.setAdapter(adapter)
    }
    fun conectar(){
        //iniciar Firebase
        FirebaseApp.initializeApp(this)
        //acceder a la base de datos
        bd=FirebaseDatabase.getInstance().reference
    }
}









