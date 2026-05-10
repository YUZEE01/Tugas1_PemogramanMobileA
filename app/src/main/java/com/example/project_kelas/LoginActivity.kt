package com.example.project_kelas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_kelas.databinding.ActivityLoginBinding
import com.example.project_kelas.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
//
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = this.intent
        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")
        Toast.makeText(this,username + " " + password, Toast.LENGTH_SHORT).show()

        binding.buttonLogin.setOnClickListener {
            val usernameLogin = binding.editTextUsername.text.toString()
            val passwordLogin = binding.editTextPassword.text.toString()
            if(usernameLogin.isEmpty()){
                binding.editTextUsername.error = "Username tidak boleh kosong"
            }else if(passwordLogin.isEmpty()){
                binding.editTextPassword.error = "Password tidak boleh kosong"
            }else if(usernameLogin != username){
                binding.editTextUsername.error = "Username salah"
            }else if(passwordLogin != password){
                binding.editTextPassword.error = "Password salah"
            }else{
                var loginSuccess : String = "Login Berhasil"
                Toast.makeText(this, loginSuccess, Toast.LENGTH_SHORT).show()

                val intentMainMenu = Intent(this, MainMenuActivity::class.java)
                intentMainMenu.putExtra("USERNAME", usernameLogin)
                startActivity(intentMainMenu)
            }
        }
    }
}