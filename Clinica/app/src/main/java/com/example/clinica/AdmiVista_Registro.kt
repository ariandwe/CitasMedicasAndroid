package com.example.clinica

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.adaptador.AdaptadorRegistro
import com.example.clinica.arreglo.ArregloRegistro

class AdmiVista_Registro: AppCompatActivity() {
    private lateinit var rvRegistro: RecyclerView
    private lateinit var btnNuevoPaciente: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_registro)

        rvRegistro=findViewById(R.id.rvRegistro)
        btnNuevoPaciente=findViewById(R.id.btnNuevoP)
        btnNuevoPaciente.setOnClickListener({nuevoPaciente()})
        //invocar al método listado
        val datos= ArregloRegistro().listado()
        //crear un objeto de la clase AdaptadorCita
        val adaptador= AdaptadorRegistro(datos)
        //definir tipo de datos a mostrar en RecyclerView(vertical/horizontal)
        rvRegistro.layoutManager= LinearLayoutManager(this)
        //enviar el valor adaoatdor al atributo "rvRegistro"
        rvRegistro.adapter=adaptador

    }
    fun nuevoPaciente(){
        var intent=Intent(this,AdmiNuevoPaciente::class.java)
        startActivity(intent)
    }
}