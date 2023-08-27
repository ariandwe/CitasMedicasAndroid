package com.example.clinica


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivityP : AppCompatActivity() {

    private lateinit var btnSesion: Button
    private lateinit var txtRegistro: TextView
    private lateinit var txtCorreo: EditText
    private lateinit var txtContra: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSesion = findViewById(R.id.btn_go_to_menu)
        txtRegistro = findViewById(R.id.tv_go_to_register)
        txtCorreo = findViewById(R.id.edtCorreoL)
        txtContra = findViewById(R.id.edtContraseñaL)

        btnSesion.setOnClickListener { authenticateUser() }
        txtRegistro.setOnClickListener { goToRegister() }
    }

    private fun authenticateUser() {
        val correo = txtCorreo.text.toString()
        val contrasena = txtContra.text.toString()

        if (correo == "admin@gmail.com" && contrasena == "admin123") {
            val intent = Intent(this, AdmiMenu::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MenuActivityP::class.java)
            startActivity(intent)
        }
    }

    private fun goToRegister() {
        val intent = Intent(this, CrearPacienteP::class.java)
        startActivity(intent)
    }
}