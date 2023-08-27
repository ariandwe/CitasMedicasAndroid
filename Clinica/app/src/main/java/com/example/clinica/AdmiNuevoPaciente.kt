package com.example.clinica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clinica.arreglo.ArregloRegistro
import com.example.clinica.clase.Registro
import com.google.android.material.textfield.TextInputEditText

class AdmiNuevoPaciente: AppCompatActivity() {
    private lateinit var txtNombres: TextInputEditText
    private lateinit var txtApellidos: TextInputEditText
    private lateinit var txtCorreo: TextInputEditText
    private lateinit var txtContraseña: TextInputEditText
    private lateinit var btnGrabarPaciente: Button
    private lateinit var btnVolver:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nuevo_paciente)
        txtNombres=findViewById(R.id.edtNombresN)
        txtApellidos=findViewById(R.id.edtApellidoN)
        txtCorreo=findViewById(R.id.edtCorreoN)
        txtContraseña=findViewById(R.id.edtContraseñaN)
        btnGrabarPaciente=findViewById(R.id.btnGrabarPacienteN)
        btnVolver=findViewById(R.id.btnVolver)
        btnGrabarPaciente.setOnClickListener({insertarPaciente()})
        btnVolver.setOnClickListener({volver()})

}
    fun volver(){
        val intent= Intent(this,AdmiVista_Registro::class.java)
        startActivity(intent)
    }
    fun insertarPaciente(){
        //crear objeto de la clase Docente con los valores de los
        //controles
        var pac= Registro(0,txtNombres.text.toString(),
            txtApellidos.text.toString(),
            txtCorreo.text.toString(),
            txtContraseña.text.toString(),"")
        //invocar al metrodo registrarPaciente
        var salida= ArregloRegistro().registrarPaciente(pac)

        if(salida==-1)
            Toast.makeText(this,"Error en el registro",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Paciente registrado",
                Toast.LENGTH_LONG).show()
    }
}