package com.example.clinica.adaptador

import android.content.Intent
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.AdmiEditarCita
import com.example.clinica.R
import com.example.clinica.clase.Cita2
import com.example.clinica.util.AppConfig

class AdaptadorCita(val datos: ArrayList<Cita2>):RecyclerView.Adapter<VistaCita>() {
    //2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCita {
       //crear inflador
        val inflador= LayoutInflater.from(parent.context).
            inflate(R.layout.item_cita,parent,false)
        return VistaCita(inflador)
    }

    //1
    override fun getItemCount(): Int {
        //retornar la cantidad de registros que tiene el arreglo de objetos "datos"
        return datos.size
    }
    //3
    override fun onBindViewHolder(holder: VistaCita, position: Int) {
       //mostrar los valores del arreglo en VistaDocente
       holder.tvCodigo.text=datos.get(position).codigo.toString()
       //holder.tvNombres.text=datos.get(position).nombres
       //holder.tvApellidos.text=datos.get(position).apellidos
       holder.tvSintomas.text=datos.get(position).sintoma
        holder.tvEspecialidad.text=datos.get(position).especialidad
        holder.tvConsulta.text=datos.get(position).consulta
        holder.tvMedico.text=datos.get(position).medico
        holder.tvFecha.text=datos.get(position).fecha
        holder.tvHora.text=datos.get(position).hora
        //holder.tvEstado.text=datos.get(position).estado
        //Crear contexto de la vista actual "holder"
        //var context: Context =holder.itemView.context
        //var ID:Int
        //Crear identificador de IMG según el valor que almacena el atributo foto
        //ID=context.resources.getIdentifier(datos.get(position).foto,"drawable",context.packageName)
        //holder.imgFoto.setImageResource(ID)
        //asignar evento click al parámetro holder
        holder.itemView.setOnClickListener({
            val intent= Intent(AppConfig.CONTEXTO, AdmiEditarCita::class.java)
            intent.putExtra("citas",datos.get(position))
            ContextCompat.startActivity(AppConfig.CONTEXTO,intent,null)
        }
        )
    }




}



