package cl.aiep.android.notfoundteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class BuscarPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_paciente)
    }

    fun editarPaciente(view: View) {
        Toast.makeText(this, "Función en desarrollo, intente nuevamente en versiones posteriores de la app", Toast.LENGTH_LONG).show()
    }

    fun eliminarPaciente(view: View) {
        Toast.makeText(this, "Función en desarrollo, intente nuevamente en versiones posteriores de la app", Toast.LENGTH_LONG).show()
    }

    fun volver(view: View) {
        startActivity(Intent(this, dashboard::class.java))
    }
}