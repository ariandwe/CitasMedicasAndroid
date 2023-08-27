package com.example.clinica

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clinica.arreglo.ArregloRegistro
import com.example.clinica.clase.Registro


class CrearPacienteP:AppCompatActivity() {

    private lateinit var txtNombres:EditText
    private lateinit var txtApellidos:EditText
    private lateinit var txtCorreo:EditText
    private lateinit var txtContraseña:EditText
    private lateinit var btnGrabarPaciente:Button
    private lateinit var txtLogin: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        txtNombres=findViewById(R.id.edtNombre)
        txtApellidos=findViewById(R.id.edtApellido)
        txtCorreo=findViewById(R.id.edtCorreo)
        txtContraseña=findViewById(R.id.edtContraseña)
        btnGrabarPaciente=findViewById(R.id.btnRegistrar)
        txtLogin=findViewById(R.id.tv_go_to_login)
        btnGrabarPaciente.setOnClickListener({registrar()})
        txtLogin.setOnClickListener({gologin()})
    }
    fun gologin(){
        val i = Intent(this,MainActivityP::class.java)
        startActivity(i)
    }
    fun registrar(){
        //crear objeto de la clase Docente con los valores de los
        //controles
        var pac=Registro(0,txtNombres.text.toString(),
        txtApellidos.text.toString(),
        txtCorreo.text.toString(),
        txtContraseña.text.toString(),"")
        //invocar al metrodo registrarPaciente
        var salida=ArregloRegistro().registrarPaciente(pac)

        if(salida==-1)
            Toast.makeText(this,"Error en el registro",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Paciente registrado",
                Toast.LENGTH_LONG).show()

    }
}