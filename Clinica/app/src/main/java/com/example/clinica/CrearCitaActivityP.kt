package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.clinica.arreglo.ArregloCita

import com.example.clinica.clase.Cita2
import com.google.android.material.textfield.TextInputEditText

class CrearCitaActivityP : AppCompatActivity() {

    private lateinit var atvEspecialidad: AutoCompleteTextView
    private lateinit var txtSintoma: TextInputEditText
    private lateinit var atvMedico: AutoCompleteTextView
    private lateinit var atvConsulta:AutoCompleteTextView
    private lateinit var atvAtencion:AutoCompleteTextView
    private lateinit var txtFecha: TextInputEditText
    private lateinit var btnSiguiente:Button
    private lateinit var btnConfirmar:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_cita)
        //declarar los botones con su variable de la vista "crear_cita"
        btnSiguiente=findViewById(R.id.btn_siguiente)
        btnConfirmar=findViewById(R.id.btn_confirmar)

        //variables para cambiar de vista del cardview
        val cvNext = findViewById<CardView>(R.id.cv_siguiente)
        val cvConfirm = findViewById<CardView>(R.id.cv_confirmar)

        btnSiguiente.setOnClickListener({cvNext.visibility = View.GONE
        cvConfirm.visibility = View.VISIBLE})

        //declarar las variables de spinner
        atvEspecialidad=findViewById(R.id.spnEspecialidad)
        atvConsulta=findViewById(R.id.spnConsulta)
        atvMedico=findViewById(R.id.spnMedico)
        atvAtencion=findViewById(R.id.spnAtencion)
       // atvHora=findViewById(R.id.spnHora)

        txtSintoma=findViewById(R.id.edtSintomas)
        txtFecha=findViewById(R.id.edtFecha)


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
        //asignar evento click al botón btnGrabar
        btnConfirmar.setOnClickListener({confirmar()})


    }

    fun confirmar(){
        //crear objeto de la clase Cita con los valores de los
        //controles
        var cit=Cita2(0,txtSintoma.text.toString(),
            atvEspecialidad.text.toString(),
            atvConsulta.text.toString(),
            atvMedico.text.toString(),
            txtFecha.text.toString(),
            atvAtencion.text.toString(),"")
        //invocar al método registrarCita
        var salida= ArregloCita().registrarCita(cit)
        if(salida==-1)
            Toast.makeText(this,"Error en el registro",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Cita registrada",
                Toast.LENGTH_LONG).show()
        var intent= Intent(this,MenuActivityP::class.java)

        startActivity(intent)
        finish()
    }



}