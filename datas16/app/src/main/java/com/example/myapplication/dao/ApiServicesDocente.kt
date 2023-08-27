package com.example.myapplication.dao

import com.example.myapplication.clase.Docente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServicesDocente {
    @GET("/docente/lista")
    fun listarDocentes(): Call<List<Docente>>
    @POST("/docente/registrar")
    fun registrarDocente(@Body bean:Docente): Call<Void>
    @GET("/docente/buscar/{codigo}")
    fun buscarDocente(@Path("codigo") cod:Int): Call<Docente>
    @PUT("/docente/actualizar")
    fun actualizarDocente(@Body bean:Docente): Call<Void>

}