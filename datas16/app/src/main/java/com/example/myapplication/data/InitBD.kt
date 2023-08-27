package com.example.myapplication.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.utils.AppConfig

class InitBD: SQLiteOpenHelper(AppConfig.CONTEXTO,
                               AppConfig.NOMBRE_BD,
                               null,AppConfig.VERSION){
    override fun onCreate(p0: SQLiteDatabase) {
        //crear tabla
        p0.execSQL("create table tb_curso("+
                        "cod Integer primary key autoincrement,"+
                        "nom varchar(30))")
        //insertar registros
        p0.execSQL("insert into tb_curso values(null,'Java')")
        p0.execSQL("insert into tb_curso values(null,'C#')")
        p0.execSQL("insert into tb_curso values(null,'PHP')")
        p0.execSQL("insert into tb_curso values(null,'Angular')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}