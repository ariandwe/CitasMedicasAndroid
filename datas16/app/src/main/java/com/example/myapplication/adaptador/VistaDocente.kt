package com.example.myapplication.adaptador

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class VistaDocente(var vista:View):RecyclerView.ViewHolder(vista) {
    //atributos
    var tvCodigo:TextView
    var tvNombres:TextView
    var tvPaterno:TextView
    var tvMaterno:TextView
    var imgFoto:ImageView

    //bloque para inicializar
    init {
        //referenciar atributos con los controles del parámetro vista
        tvCodigo=vista.findViewById(R.id.tvCodigo)
        tvNombres=vista.findViewById(R.id.tvNombres)
        tvPaterno=vista.findViewById(R.id.tvPaterno)
        tvMaterno=vista.findViewById(R.id.tvMaterno)
        imgFoto=vista.findViewById(R.id.imgFoto)
    }
}

