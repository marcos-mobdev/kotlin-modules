package br.com.appforge.kotlinmodules

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.appforge.api.Retrofit
import br.com.appforge.auth.AuthenticationActivity
import br.com.appforge.database.AppDatabase
import br.com.appforge.kotlinmodules.databinding.ActivityMainBinding
import br.com.appforge.payment.Payment

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Payment.creditCard()
        Retrofit.setup()
        AppDatabase.setupDatabase()

        binding.btnOpenLogin.setOnClickListener {
            startActivity(Intent(this,AuthenticationActivity::class.java))
        }
    }
}