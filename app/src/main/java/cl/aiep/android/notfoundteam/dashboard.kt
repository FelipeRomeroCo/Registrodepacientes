package cl.aiep.android.notfoundteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun crearNuevoIngreso(view: View) {
        startActivity(Intent(this, NuevoIngreso::class.java))
    }
    fun verIngresos(view: View) {
        startActivity(Intent(this, Registros::class.java))
    }
}