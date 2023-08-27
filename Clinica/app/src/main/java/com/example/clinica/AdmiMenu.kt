package com.example.clinica

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class AdmiMenu : AppCompatActivity() {

    private lateinit var btnCita:Button
    private lateinit var btnRPaciente:Button
    private lateinit var btnRMedico:Button
    private lateinit var btnSalir:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admi_menu)

        btnCita=findViewById(R.id.btnCita)
        btnRPaciente=findViewById(R.id.btnPaciente)
        btnSalir=findViewById(R.id.btnSalir)

        //3
        btnCita.setOnClickListener({gestionCitas()})
        btnRPaciente.setOnClickListener({mostrarPacientes()})
        btnSalir.setOnClickListener({goToLogin()})
    }


    fun gestionCitas(){
        val i = Intent(this,AdmiVista_Cita::class.java)
        startActivity(i)
        finish()
    }

    fun mostrarPacientes(){
        val i = Intent(this,AdmiVista_Registro::class.java)
        startActivity(i)
        finish()
    }

    fun goToLogin(){
        val i = Intent(this,MainActivityP::class.java)
        startActivity(i)
        finish()
    }

}