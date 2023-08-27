package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.clase.Distrito
import com.example.myapplication.clase.Docente
import com.example.myapplication.dao.ApiServicesDistrito
import com.example.myapplication.dao.ApiServicesDocente
import com.example.myapplication.utils.ApiUtils
import com.example.myapplication.utils.AppConfig
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditarActivity:AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var atvDistritos:AutoCompleteTextView
    private lateinit var txtNombre:TextInputEditText
    private lateinit var txtPaterno:TextInputEditText
    private lateinit var txtMaterno:TextInputEditText
    private lateinit var txtSueldo:TextInputEditText
    private lateinit var txtHijos:TextInputEditText
    private lateinit var txtDireccion:TextInputEditText
    private lateinit var atvSexo:AutoCompleteTextView
    private lateinit var btnGrabar:Button
    private lateinit var btnVolver:Button
    //declarar un objeto de la interfaz ApiServicesDistrito
    private lateinit var apiDistrito: ApiServicesDistrito
    //
    private lateinit var apiDocente: ApiServicesDocente

    var dis:Int=-1
    var codigoDocente=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editar_activity)
        atvDistritos=findViewById(R.id.spnDistritosE)
        txtNombre=findViewById(R.id.edtNombresE)
        txtPaterno=findViewById(R.id.edtPaaternoE)
        txtMaterno=findViewById(R.id.edtMaternoE)
        txtSueldo=findViewById(R.id.edtSueldoE)
        txtHijos=findViewById(R.id.edtHijosE)
        txtDireccion=findViewById(R.id.edtDireccionE)
        atvSexo=findViewById(R.id.spnSexoE)
        btnGrabar=findViewById(R.id.btnActualizar)
        //btnVolver=findViewById(R.id.btnVolver)

        //crear objeto apiDistrito
        apiDistrito=ApiUtils.getAPIServiceDistrito()
        //
        apiDocente=ApiUtils.getAPIServiceDocente()

        //asignar evento click al botón btnGrabar
        btnGrabar.setOnClickListener({insertarDocente()})
//        btnVolver.setOnClickListener({volver()})

        cargarDistritos()
        val sexos= arrayListOf("Masculino","Femenino")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,sexos)
        atvSexo.setAdapter(adapter)

        atvDistritos.onItemClickListener=AdapterView.OnItemClickListener{
            parent,view,position,id->dis=position+1
        }
        datos()

    }
    fun volver(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun insertarDocente(){
        val nom:String;val pat:String;val mat:String;val sexo:String
        val sue:Double;val hijos:Int;val dir:String
        nom=txtNombre.text.toString()
        pat=txtPaterno.text.toString()
        mat=txtMaterno.text.toString()
        sexo=atvSexo.text.toString()
        sue=txtSueldo.text.toString().toDouble()
        hijos=txtHijos.text.toString().toInt()
        dir=txtDireccion.text.toString()
        val beanDis=Distrito(dis,"")
        //crear objeto de Docente
        val doc=Docente(codigoDocente,nom,pat,mat,sexo,sue,hijos,dir,beanDis)
        actualizar(doc)

    }
    //método
    fun cargarDistritos(){
        //invocar al método listarDistritos
        apiDistrito.listarDistritos().enqueue(object: Callback<List<Distrito>>{
            override fun onResponse(call: Call<List<Distrito>>,response: Response<List<Distrito>>) {
                //recuperar el arreglo de objetos que almacena response
                val datos=response.body()!!
                //declarar arreglo de tipo cadena
                var distritos=ArrayList<String>()
                //bucle para realizar recorrido sobre datos
                datos.forEach{ dis->
                    //adicionar nombre del distrito dentro del arreglo "distritos"
                    distritos.add(dis.nombre)

                }
                //adaptador
                val adapter=ArrayAdapter<String>(AppConfig.CONTEXTO, android.R.layout.simple_list_item_1,
                            distritos)
                atvDistritos.setAdapter(adapter)
            }
            override fun onFailure(call: Call<List<Distrito>>, t: Throwable) {

            }
        })
    }

    fun actualizar(beanDoc:Docente){
        apiDocente.actualizarDocente(beanDoc).enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(AppConfig.CONTEXTO,"Docente actualizado",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(AppConfig.CONTEXTO,t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(AppConfig.CONTEXTO,""+p1,Toast.LENGTH_LONG).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun datos(){
        val bundle=intent.extras
        var cod=bundle!!.getInt("codigo")
        codigoDocente=cod
        apiDocente.buscarDocente(cod).enqueue(object: Callback<Docente>{
            override fun onResponse(call: Call<Docente>, response: Response<Docente>) {
               val doc=response.body()
               txtNombre.setText(doc!!.nombre)
               txtPaterno.setText(doc!!.paterno)
               txtMaterno.setText(doc!!.materno)
               atvSexo.setText(doc!!.sexo,false)
               txtSueldo.setText(doc!!.sueldo.toString())
               txtHijos.setText(doc!!.hijos.toString())
               txtDireccion.setText(doc!!.direccion)
               atvDistritos.setText(doc!!.distrito.nombre,false)
               dis=doc!!.distrito.codigo
            }
            override fun onFailure(call: Call<Docente>, t: Throwable) {
               Toast.makeText(AppConfig.CONTEXTO,t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })
    }


}









