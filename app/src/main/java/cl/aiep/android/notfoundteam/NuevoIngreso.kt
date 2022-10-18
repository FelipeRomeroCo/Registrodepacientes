package cl.aiep.android.notfoundteam

import android.os.Bundle
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
        val nombres = binding.etNombres.text.toString()
        val apellidos = binding.etApellidos.text.toString()
        val rut = binding.etRut.text.toString()
        val fechanacimiento = binding.etFechaDeNacimiento.text.toString()
        val sexo = binding.etSexo.text.toString()

        val datoIngreso = Ingresos(
            null,
            nombres,
            apellidos,
            rut,
            fechanacimiento,
            sexo
        )


        //Vamos a declarar la base de datos
        val baseDeDatos = BaseDeDatos(this, NOMBRE_BASE, null, VERSION_BD)
        //Vamos a guardar el dato
        val status = baseDeDatos.agregarIngresos(datoIngreso)
        if (status > -1) {
            Toast.makeText(this, "Dato guardardo con exito ($status)", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error al guardar el dato ($status)", Toast.LENGTH_LONG).show()
        }
    }
}