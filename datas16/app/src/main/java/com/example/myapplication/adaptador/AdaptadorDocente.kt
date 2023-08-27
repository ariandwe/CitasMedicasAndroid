package com.example.myapplication.adaptador

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.EditarActivity
import com.example.myapplication.R
import com.example.myapplication.clase.Docente
import com.example.myapplication.utils.AppConfig

class AdaptadorDocente(val datos: List<Docente>):RecyclerView.Adapter<VistaDocente>() {
    //2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaDocente {
       //crear inflador
        val inflador= LayoutInflater.from(parent.context).
            inflate(R.layout.item_docente,parent,false)
        return VistaDocente(inflador)
    }

    //1
    override fun getItemCount(): Int {
        //retornar la cantidad de registros que tiene el arreglo de objetos "datos"
        return datos.size
    }
    //3
    override fun onBindViewHolder(holder: VistaDocente, position: Int) {
       //mostrar los valores del arreglo en VistaDocente
       holder.tvCodigo.text=datos.get(position).codigo.toString()
       holder.tvNombres.text=datos.get(position).nombre
       holder.tvPaterno.text=datos.get(position).paterno
       holder.tvMaterno.text=datos.get(position).materno

       holder.itemView.setOnClickListener{
           var intent=Intent(AppConfig.CONTEXTO,EditarActivity::class.java)
           intent.putExtra("codigo",datos.get(position).codigo)
           ContextCompat.startActivity(AppConfig.CONTEXTO,intent,null)
       }
    }


}