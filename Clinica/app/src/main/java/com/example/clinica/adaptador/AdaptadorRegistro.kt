package com.example.clinica.adaptador

import android.content.Intent
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.AdmiEditarCita
import com.example.clinica.AdmiEditarPaciente
import com.example.clinica.R
import com.example.clinica.clase.Registro
import com.example.clinica.util.AppConfig

class AdaptadorRegistro(val datos: ArrayList<Registro>):RecyclerView.Adapter<VistaRegistro>() {
    //2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaRegistro {
        //crear inflador
        val inflador= LayoutInflater.from(parent.context).
        inflate(R.layout.item_registro,parent,false)
        return VistaRegistro(inflador)
    }

    //1
    override fun getItemCount(): Int {
        //retornar la cantidad de registros que tiene el arreglo de objetos "datos"
        return datos.size
    }
    //3
    override fun onBindViewHolder(holder: VistaRegistro, position: Int) {
        //mostrar los valores del arreglo en VistaDocente
        holder.tvCodigo.text=datos.get(position).codigo.toString()
        holder.tvNombre.text=datos.get(position).nombres
        holder.tvApellidos.text=datos.get(position).apellidos
        holder.tvCorreo.text=datos.get(position).correo
        holder.tvContraseña.text=datos.get(position).contraseña
        //Crear contexto de la vista actual "holder"
        //var context: Context =holder.itemView.context
        //var ID:Int
        //Crear identificador de IMG según el valor que almacena el atributo foto
        //ID=context.resources.getIdentifier(datos.get(position).foto,"drawable",context.packageName)
        //holder.imgFoto.setImageResource(ID)
        //asignar evento click al parámetro holder
        holder.itemView.setOnClickListener({
            val intent= Intent(AppConfig.CONTEXTO, AdmiEditarPaciente::class.java)
            intent.putExtra("pacientes",datos.get(position))
            ContextCompat.startActivity(AppConfig.CONTEXTO,intent,null)
        }
        )
    }




}





