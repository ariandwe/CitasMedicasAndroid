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



import com.google.android.material.textfield.TextInputEditText

class AdmiEditarCita:AppCompatActivity() {
    private lateinit var atvEspecialidad:AutoCompleteTextView
    private lateinit var txtSintoma:TextInputEditText
    private lateinit var atvMedico:AutoCompleteTextView
    private lateinit var atvConsulta:AutoCompleteTextView
    private lateinit var atvAtencion:AutoCompleteTextView
    private lateinit var txtFecha:TextInputEditText
    private lateinit var btnActualizar:Button
    private lateinit var btnVolver:Button
    private lateinit var txtCodigo:TextInputEditText
    private lateinit var btnEliminar:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admi_editar_cita)
        txtCodigo=findViewById(R.id.edtCodigoE)
        atvEspecialidad=findViewById(R.id.spnEspecialidadE)
        txtSintoma=findViewById(R.id.edtSintomasE)
        atvMedico=findViewById(R.id.spnMedicoE)
        txtFecha=findViewById(R.id.edtFechaE)
        atvConsulta=findViewById(R.id.spnConsultaE)
        atvAtencion=findViewById(R.id.spnAtencionE)
        btnEliminar=findViewById(R.id.btnEliminarE)
        btnVolver=findViewById(R.id.btnVolverE)
        btnActualizar=findViewById(R.id.btnActualizarE)

        //arreglo especialidad
        val especialidad = arrayOf("Neumología","Neurologo","Cardiologo","Ginecologa","Dentista")

        //arreglo medico
        val medico = arrayOf("Luis Perez", "Arian Aranda", "Lucas Lopez", "Jacinto Poza","Eugenia Miranda")

        //areglo hora de atencion
        val atencion = arrayOf("8:00AM", "9:00AM", "10:00AM", "11:00AM","12:00PM")

        //arreglo de tipo de consulta
        val consulta = arrayOf("Consulta", "Examen", "Operación")

        //adaptador espeecialidad
        val adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,especialidad)

        //adaptador medico
        val adapter1= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,medico)

        //adaptador hora atencion
        val adapter2= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,atencion)

        //adaptador hora atencion
        val adapter3= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,consulta)
        //enviar objeto "adapter" al atributo atvEspecialidad (Especialidades)
        atvEspecialidad.setAdapter(adapter)
        //enviar objeto "adapter1" al atributo atvMedico (Medicos)
        atvMedico.setAdapter(adapter1)
        //enviar objeto"adapter2" al atributo atvAtencion (horarios)
        atvAtencion.setAdapter(adapter2)
        //enviar objeto "adapter3" al atributo atvConsulta
        atvConsulta.setAdapter(adapter3)

        btnActualizar.setOnClickListener({modificarCita()})
        btnVolver.setOnClickListener({volver()})
        btnEliminar.setOnClickListener({mensajeEliminar()})

        datos()
    }
    fun volver(){
        val intent=Intent(this,AdmiVista_Cita::class.java)
        startActivity(intent)
    }

    fun modificarCita(){
//crear objeto de la clase Cita con los valores de los
        //controles
       var cit= Cita2(txtCodigo.text.toString().toInt(),
                        txtSintoma.text.toString(),
                        atvEspecialidad.text.toString(),
                        atvConsulta.text.toString(),
                        atvMedico.text.toString(),
                        txtFecha.text.toString(),
                        atvAtencion.text.toString(),"")
        //invocar al método actualizarCita
        var salida= ArregloCita().actualizarCita(cit)
        //validar salida
        if(salida ==-1)
            Toast.makeText(this,"Error en la actualización",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Cita actualizada",
                Toast.LENGTH_LONG).show()
        finish()
    }

    fun mensajeEliminar(){
        val dialogo1: AlertDialog.Builder = AlertDialog.Builder(this)
        dialogo1.setTitle("Eliminar")
        dialogo1.setMessage("¿Seguro de eliminar?")
        dialogo1.setCancelable(false)
        dialogo1.setPositiveButton("Aceptar",
        DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i:Int ->
            var salida=ArregloCita().eliminarCita(txtCodigo.text.toString().toInt())
            //validar salida
            if(salida==-1)
                Toast.makeText(this,"Error en la eliminación",Toast.LENGTH_LONG).show()
            else{
                Toast.makeText(this,"Cita eliminado",Toast.LENGTH_LONG).show()
            }
        })
        dialogo1.setNegativeButton("Cancelar",
        DialogInterface.OnClickListener{dialogo1, id ->})
        dialogo1.setIcon(android.R.drawable.ic_dialog_alert)
        dialogo1.show()
    }


    fun datos(){
        //recuperar clave "citas" que es de tipo
        //clase Cita2
        val data=intent.getSerializableExtra("citas") as Cita2
        txtCodigo.setText(data.codigo.toString())
        txtSintoma.setText(data.sintoma)
        atvEspecialidad.setText(data.especialidad)
        atvConsulta.setText(data.consulta)
        atvMedico.setText(data.medico)
        txtFecha.setText(data.fecha)
        atvAtencion.setText(data.hora,false)

        }


}










