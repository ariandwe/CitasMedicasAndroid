package com.example.clinica.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.clinica.util.AppConfig

class InitBD: SQLiteOpenHelper(AppConfig.CONTEXTO,
    AppConfig.NOMBRE_BD,
    null,AppConfig.VERSION){
    override fun onCreate(p0: SQLiteDatabase) {
        //crear tabla
        p0.execSQL("create table cita("+
                "cod Integer primary key autoincrement,"+
                "sintoma varchar(300),"+
                "especialidad varchar(100),"+
                "consulta varhcar(30),"+
                "medico varchar(100),"+
                "fecha varchar(100),"+
                "hora varchar(30)," +
                "foto varchar(10))")
        //insertar registros
        p0.execSQL("insert into cita values(null,'Me duele los pulmones','Neumologo','Consulta','Luis Perez','2023-07-10','09:00:00','')")
        //p0.execSQL("insert into cita values(null,'Javier','Perez Maguiña','Me duele los pulmones','Neumologo','Lucas Lopez','2023-08-10 10:00:00','Pendiente','')")

        p0.execSQL("create table paciente("+
                "cod Integer primary key autoincrement,"+
                "nombres varchar(100),"+
                "apellidos varchar(100),"+
                "correo varchar(100),"+
                "contraseña varchar(100)," +
                "foto varchar(100))")
        //insertar registros
        p0.execSQL("insert into paciente values(null,'Josue Anthony','Poza Perez','josue@gmail.com','josue123','')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}


