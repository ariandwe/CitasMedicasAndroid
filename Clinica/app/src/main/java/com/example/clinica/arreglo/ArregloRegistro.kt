package com.example.clinica.arreglo


import android.content.ContentValues
import android.database.Cursor

import com.example.clinica.clase.Registro
import com.example.clinica.util.AppConfig

class ArregloRegistro {
    fun listado(): ArrayList<Registro>{
        //crear un arreglo de objetos de la clase Cita
        var data = ArrayList<Registro>()
        //abrir la conexión a la base de datos en modo lectura
        var cn = AppConfig.BD.readableDatabase
        //ejecutar sentencia "select" y guardar su contenido en un
        //objeto de tipo Cursor
        var rs: Cursor = cn.rawQuery("select * from paciente", null)
        //bucle para realizar recorrido sobre rs
        while (rs.moveToNext()) {
            //crear objeto de la clase Docente con los valores de la
            //fila actual(rs)
            var bean = Registro(
                rs.getInt(0), rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getString(4),
                rs.getString(5))
            //adicionar objeto "bean" en el arreglo "data"
            data.add(bean)
        }
        return data
    }

    fun registrarPaciente(bean: Registro):Int{
        var estado =-1
        //Abrire el acceso a la base de datos en modo escritura
        var cn=AppConfig.BD.writableDatabase
//        Crear un objeto de la clase ContentValues
        var row = ContentValues()
//        Crear claves dentro del objeto "row" donde las claves son los nombres de los campos
//        de la tabla tb_docente
        row.put("nombres",bean.nombres)
        row.put("apellidos",bean.apellidos)
        row.put("correo",bean.correo)
        row.put("contraseña",bean.contraseña)
        row.put("foto",bean.foto)


        //Invocar al método insert
        estado = cn.insert("paciente","cod",row).toInt()

        return estado
    }
    fun actualizarPaciente(bean: Registro):Int{
        var estado=-1//Abrir el acceso a la base de datos en modo de escritura
        var cn=AppConfig.BD.writableDatabase
        //Crear un objeto de la clase ContentValues
        var row = ContentValues()
        //Crear claves dentro del objeto "row" donde las claves son los nombres de los campos
        //de la tabla paciente
        row.put("nombres",bean.nombres)
        row.put("apellidos",bean.apellidos)
        row.put("correo",bean.correo)
        row.put("contraseña",bean.contraseña)
        row.put("foto",bean.foto)

        //Update table set campo1=valor1 where campo_llave=1
        //Invocar al método insert
        estado = cn.update("paciente",row,"cod=?",
                arrayOf((bean.codigo.toString()))
        )
        return estado
    }

    fun eliminarPaciente(codigo:Int):Int{
        var estado=-1
        //abrir el acceso a la base de datos en modo escritura
        var cn=AppConfig.BD.writableDatabase
        //delete from tabla where campo=1
        estado=cn.delete("paciente","cod=?", arrayOf(codigo.toString()))
        return estado
    }
}