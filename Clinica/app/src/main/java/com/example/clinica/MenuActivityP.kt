package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MenuActivityP : AppCompatActivity() {

    private lateinit var btnRegistrar:Button
    private lateinit var Cita:Button
    private lateinit var Salir:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnRegistrar=findViewById(R.id.btn_registrar_cita)
        Cita=findViewById(R.id.btn_mis_citas)
        Salir=findViewById(R.id.btn_salir)
        //3
      btnRegistrar.setOnClickListener({goToCita()})
        Cita.setOnClickListener({mostrarCita()})
        Salir.setOnClickListener({goToLogin()})
    }

//boton salir
    private fun goToLogin(){
        val i = Intent(this,MainActivityP::class.java)
        startActivity(i)
        finish()
    }
//boton citas
    fun mostrarCita(){
        val i = Intent(this,Vista_CitaP::class.java)
        startActivity(i)
        finish()
    }
//boton registrar cita
    fun goToCita(){
        val i = Intent(this, CrearCitaActivityP::class.java)
        startActivity(i)
    }

}