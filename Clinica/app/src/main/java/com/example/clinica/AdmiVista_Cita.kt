package com.example.clinica

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.adaptador.AdaptadorCita
import com.example.clinica.arreglo.ArregloCita

class AdmiVista_Cita : AppCompatActivity() {

    private lateinit var rvACita:RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admi_vista_cita)

        rvACita=findViewById(R.id.rvACita)

        //invocar al método listado
        val datos=ArregloCita().listado()
        //crear un objeto de la clase AdaptadorCita
        val adaptador=AdaptadorCita(datos)
        //definir tipo de datos a mostrar en RecyclerView(vertical/horizontal)
        rvACita.layoutManager=LinearLayoutManager(this)
        //enviar el valor adaoatdor al atributo "rvCita"
        rvACita.adapter=adaptador

    }
}