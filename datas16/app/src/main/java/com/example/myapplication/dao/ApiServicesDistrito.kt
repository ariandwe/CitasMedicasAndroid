package com.example.myapplication.dao

import com.example.myapplication.clase.Distrito
import retrofit2.Call
import retrofit2.http.GET

interface ApiServicesDistrito {
    //sincronizar los métodos de la interfza con las direcciones
    //url del API(/distrito/........)
     @GET("/distrito/lista")
    //método que retorna todos los distritos
     fun listarDistritos(): Call<List<Distrito>>
}