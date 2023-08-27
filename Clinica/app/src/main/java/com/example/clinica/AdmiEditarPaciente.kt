package com.example.clinica


import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.clinica.arreglo.ArregloCita
import com.example.clinica.arreglo.ArregloRegistro

import com.example.clinica.clase.Cita2
import com.example.clinica.clase.Registro


import com.google.android.material.textfield.TextInputEditText

class AdmiEditarPaciente:AppCompatActivity() {
    private lateinit var txtNombres: TextInputEditText
    private lateinit var txtApellidos: TextInputEditText
    private lateinit var txtCorreo: TextInputEditText
    private lateinit var txtContraseña: TextInputEditText
    private lateinit var btnEditarPaciente: Button
    private lateinit var btnVolver:Button
    private lateinit var txtCodigo:TextInputEditText
    private lateinit var btnEliminar:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_paciente)
        txtCodigo=findViewById(R.id.edtCodigoP)
        txtNombres=findViewById(R.id.edtNombresE)
        txtApellidos=findViewById(R.id.edtApellidoE)
        txtCorreo=findViewById(R.id.edtCorreoE)
        txtContraseña=findViewById(R.id.edtContraseñaE)
        btnEditarPaciente=findViewById(R.id.btnEditarPacienteE)
        btnVolver=findViewById(R.id.btnVolverPE)
        btnEliminar=findViewById(R.id.btnEliminarP)

        btnEditarPaciente.setOnClickListener ({modificarPaciente()})
        btnVolver.setOnClickListener({volver()})
        btnEliminar.setOnClickListener({mensajeEliminar()})
        datos()
    }
    fun volver(){
        val intent=Intent(this,AdmiVista_Registro::class.java)
        startActivity(intent)
    }

    fun modificarPaciente(){
//crear objeto de la clase Cita con los valores de los
        //controles
        var pac=Registro(txtCodigo.text.toString().toInt(),
                        txtNombres.text.toString(),
                        txtApellidos.text.toString(),
                        txtCorreo.text.toString(),
                        txtContraseña.text.toString(),"")
        //invocar al método actualizarPaciente
        var salida=ArregloRegistro().actualizarPaciente(pac)
        //validar salida
        if(salida ==-1)
            Toast.makeText(this,"Error en la actualización",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Paciente actualizado",
                Toast.LENGTH_LONG).show()
    }

    fun mensajeEliminar(){
        val dialogo1: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogo1.setTitle("Eliminar")
        dialogo1.setMessage("¿Seguro de eliminar?")
        dialogo1.setCancelable(false)
        dialogo1.setPositiveButton("Aceptar",
            DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i:Int ->
                var salida=ArregloRegistro().eliminarPaciente(txtCodigo.text.toString().toInt())
                //validar salida
                if(salida==-1)
                    Toast.makeText(this,"Error en la eliminación",Toast.LENGTH_LONG).show()
                else{
                    Toast.makeText(this,"Paciente eliminado",Toast.LENGTH_LONG).show()
                }
            })
        dialogo1.setNegativeButton("Cancelar",
            DialogInterface.OnClickListener{ dialogo1, id ->})
        dialogo1.setIcon(android.R.drawable.ic_dialog_alert)
        dialogo1.show()

    }

    fun datos(){
        //recuperar clave "pacientes" que es de tipo
        //clase Docente
        val data=intent.getSerializableExtra("pacientes") as Registro
        txtCodigo.setText(data.codigo.toString())
        txtNombres.setText(data.nombres)
        txtApellidos.setText(data.apellidos)
        txtCorreo.setText(data.correo)
        txtContraseña.setText(data.contraseña)

        }

}










