package cl.aiep.android.notfoundteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cl.aiep.android.notfoundteam.Constantes.LOCAL
import cl.aiep.android.notfoundteam.adaptador.Adaptador
import cl.aiep.android.notfoundteam.bd.BaseDeDatos
import cl.aiep.android.notfoundteam.clases.Ingresos
import cl.aiep.android.notfoundteam.databinding.ActivityRegistrosBinding

class Registros : AppCompatActivity() {

    lateinit var binding: ActivityRegistrosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Nueva forma de vincular la vista con el activity
        binding = ActivityRegistrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listarData(LOCAL)
    }

    //Funcion para listar la data
    fun listarData(fuenteDatos: String) {
        //Generando una lista vacia sin data
        val listaData = ArrayList<Ingresos>()
        //Aca se decide que fuente de datos voy a usar
        //Base de datos Local
        //Vamos a declarar la base de datos
        val baseDeDatos = BaseDeDatos(this, Constantes.NOMBRE_BASE, null, Constantes.VERSION_BD)
        //Vamos a guardar el dato
        mostrarDataEnLista(baseDeDatos.listarIngresos())

    }

    private fun mostrarDataEnLista(listaData: ArrayList<Ingresos>) {
        //Creamos el adaptador con la data que recibimos
        val adaptadorDataLugares = Adaptador(listaData, binding, this)
        //Vamos a configurar la lista al recyclerView
        binding.rvRegistros.apply {
            // vertical layout
            layoutManager = LinearLayoutManager(applicationContext)
            //Grid layout
            //layoutManager = GridLayoutManager(applicationContext, 2)
            // set adapter
            adapter = adaptadorDataLugares
        }
    }
}