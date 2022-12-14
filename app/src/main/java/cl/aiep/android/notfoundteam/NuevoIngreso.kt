package cl.aiep.android.notfoundteam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.aiep.android.notfoundteam.Constantes.NOMBRE_BASE
import cl.aiep.android.notfoundteam.Constantes.VERSION_BD
import cl.aiep.android.notfoundteam.bd.BaseDeDatos
import cl.aiep.android.notfoundteam.clases.Ingresos
import cl.aiep.android.notfoundteam.databinding.ActivityNuevoIngresoBinding


class NuevoIngreso : AppCompatActivity() {

    private lateinit var binding: ActivityNuevoIngresoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Nueva forma de vincular la vista con el activity
        binding = ActivityNuevoIngresoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Vamos a asignar una accion al onclick de guardar
        binding.btnContinuar.setOnClickListener {
            guardarDatos()

        }
    }


    //Metodo para guadar datos en la base de datos Local
    private fun guardarDatos() {
        //Declarar el objeto que voy a llenar de informacion
        var nombres = binding.etNombres.editText?.text.toString()
        val apellidos = binding.etApellidos.editText?.text.toString()
        val rut = binding.etRut.editText?.text.toString()
        val fechanacimiento = binding.etFechaDeNacimiento.editText?.text.toString()
        val sexo = binding.etSexo.editText?.text.toString()
        val examen1 = binding.etExamen1.editText?.text.toString()
        val examen2 = binding.etExamen2.editText?.text.toString()
        val examen3 = binding.etExamen3.editText?.text.toString()

        val datoIngreso = Ingresos(
            null,
            nombres,
            apellidos,
            rut,
            fechanacimiento,
            sexo,
            examen1,
            examen2,
            examen3
        )


        //Vamos a declarar la base de datos
        val baseDeDatos = BaseDeDatos(this, NOMBRE_BASE, null, VERSION_BD)
        //Vamos a guardar el dato
        val status = baseDeDatos.agregarIngresos(datoIngreso)
        if (status > -1) {
            Toast.makeText(this, "Dato guardardo con ??xito ($status)", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error al guardar el dato ($status)", Toast.LENGTH_LONG).show()
        }
        limpiarDatos()
    }

    private fun limpiarDatos() {
        binding.etRut.editText?.setText("")
        binding.etNombres.editText?.setText("")
        binding.etApellidos.editText?.setText("")
        binding.etFechaDeNacimiento.editText?.setText("")
        binding.etSexo.editText?.setText("")
        binding.etExamen1.editText?.setText("")
        binding.etExamen2.editText?.setText("")
        binding.etExamen3.editText?.setText("")
    }


    fun cancelar(view: View) {
        startActivity(Intent(this, dashboard::class.java))
    }
}
