package com.example.clinica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.adaptador.AdaptadorCita
import com.example.clinica.arreglo.ArregloCita

class Vista_CitaP : AppCompatActivity() {

    private lateinit var rvCita:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_citas)

        rvCita=findViewById(R.id.rvCita)

        //invocar al método listado
        val datos=ArregloCita().listado()
        //crear un objeto de la clase AdaptadorCita
        val adaptador=AdaptadorCita(datos)
        //definir tipo de datos a mostrar en RecyclerView(vertical/horizontal)
        rvCita.layoutManager=LinearLayoutManager(this)
        //enviar el valor adaoatdor al atributo "rvDocentes"
        rvCita.adapter=adaptador

    }
}