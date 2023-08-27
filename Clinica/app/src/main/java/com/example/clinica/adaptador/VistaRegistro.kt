package com.example.clinica.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R

class VistaRegistro(var vista:View): RecyclerView.ViewHolder(vista) {
    //atributos
    var tvCodigo: TextView
    //var tvNombres: TextView
    //var tvApellidos: TextView
    var tvNombre: TextView
    var tvApellidos: TextView
    var tvCorreo: TextView
    var tvContraseña: TextView
    var imgFoto: ImageView
    //bloque para inicializar
    init {
        //referenciar atributos con los controles del parámetro vista
        tvCodigo=vista.findViewById(R.id.tvCodigo)
        tvNombre=vista.findViewById(R.id.tvNombre)
        tvApellidos=vista.findViewById(R.id.tvApellidos)
        tvCorreo=vista.findViewById(R.id.tvCorreo)
        tvContraseña=vista.findViewById(R.id.tvContraseña)
        imgFoto=vista.findViewById(R.id.imgFoto)
    }
}