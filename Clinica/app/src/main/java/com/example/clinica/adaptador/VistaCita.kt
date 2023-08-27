package com.example.clinica.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R

class VistaCita(var vista: View): RecyclerView.ViewHolder(vista) {
    //atributos
    var tvCodigo: TextView
    //var tvNombres: TextView
    //var tvApellidos: TextView
    var tvSintomas:TextView
    var tvEspecialidad: TextView
    var tvConsulta:TextView
    var tvMedico: TextView
    var tvFecha:TextView
    //var tvEstado:TextView
    var tvHora:TextView
    var imgFoto: ImageView

    //bloque para inicializar
    init {
        //referenciar atributos con los controles del parámetro vista
        tvCodigo=vista.findViewById(R.id.tvCodigo)
        //tvNombres=vista.findViewById(R.id.tvNombres)
        //tvApellidos=vista.findViewById(R.id.tvApellidos)
        tvSintomas=vista.findViewById(R.id.tvSintoma)
        tvEspecialidad=vista.findViewById(R.id.tvEspecialidad)
        tvConsulta=vista.findViewById(R.id.tvConsulta)
        tvMedico=vista.findViewById(R.id.tvMedico)
        tvFecha=vista.findViewById(R.id.tvFecha)
        tvHora=vista.findViewById(R.id.tvHora)
        //tvEstado=vista.findViewById(R.id.tvEstado)
        imgFoto=vista.findViewById(R.id.imgFoto)
    }
}