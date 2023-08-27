package com.example.clinica.util

import android.app.Application
import android.content.Context
import com.example.clinica.data.InitBD

class AppConfig: Application() {

    //bloque para declarar variables globales
    //se puede asignar valor a las variables globales
    //si son de tipo primitivo.
    companion object{
        var NOMBRE_BD="citamedica.db"
        var VERSION=1
        lateinit var CONTEXTO:Context
        lateinit var BD:InitBD
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXTO=applicationContext
        BD=InitBD()
    }


}