package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adaptador.AdaptadorDocente
import com.example.myapplication.clase.Docente
import com.example.myapplication.dao.ApiServicesDocente
import com.example.myapplication.utils.ApiUtils
import com.example.myapplication.utils.AppConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rvDocentes:RecyclerView
    private lateinit var btnNuevo:Button

    private lateinit var apiDocente:ApiServicesDocente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvDocentes=findViewById(R.id.rvDocentes)
        btnNuevo=findViewById(R.id.brnNuevo)
        //
        btnNuevo.setOnClickListener({nuevoDocente()})


        //
        apiDocente=ApiUtils.getAPIServiceDocente()
        cargarDocentes()
    }
    fun nuevoDocente(){
        var intent=Intent(this,NuevoActivity::class.java)
        startActivity(intent)
    }

    fun cargarDocentes(){
        apiDocente.listarDocentes().enqueue(object: Callback<List<Docente>> {
            override fun onResponse(call: Call<List<Docente>>, response: Response<List<Docente>>) {
                val datos=response.body()!!
                    //crear un objeto de la clase AdaptadorDocente
                val adaptador=AdaptadorDocente(datos)
                rvDocentes.layoutManager= LinearLayoutManager(AppConfig.CONTEXTO)
                rvDocentes.adapter=adaptador
            }
            override fun onFailure(call: Call<List<Docente>>, t: Throwable) {

            }
        })
    }

}