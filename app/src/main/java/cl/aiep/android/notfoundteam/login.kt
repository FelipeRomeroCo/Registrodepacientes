package cl.aiep.android.notfoundteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cl.aiep.android.notfoundteam.databinding.ActivityLoginBinding

class login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.etUsuario.text.isNullOrEmpty() || binding.etPassword.text.isNullOrEmpty()){
                Toast.makeText(this, "Debe ingresar todos los datos", Toast.LENGTH_LONG).show()
            } else{
                startActivity(Intent(this, dashboard::class.java))
            }
        }
    }

    fun salir(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}