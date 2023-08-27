package com.example.myapplication.arreglo

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.myapplication.clase.Curso
import com.example.myapplication.utils.AppConfig

class ArregloCurso {
    fun listado(): ArrayList<Curso>{
        var data=ArrayList<Curso>()
        var cn:SQLiteDatabase=AppConfig.BD.readableDatabase
        var sql="select *from tb_curso"
        var rs:Cursor=cn.rawQuery(sql,null)
        while(rs.moveToNext()) {
            var bean=Curso(rs.getInt(0),rs.getString(1))
            data.add(bean)
        }
        return data
    }


}