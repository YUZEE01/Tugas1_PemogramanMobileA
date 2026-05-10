package com.example.project_kelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_kelas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    private lateinit var editTextUsername: EditText
//    private lateinit var editTextPassword: EditText
//    private lateinit var buttonLogin: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
//
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        editTextUsername = findViewById<EditText>(R.id.editTextUsername)
//        editTextPassword = findViewById<EditText>(R.id.editTextPassword)
//        buttonLogin = findViewById<Button>(R.id.buttonLogin)
//
        binding.buttonRegis.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            var confirmPass = binding.editTextConfirmPass.text.toString()
            var fullname = binding.editTextFullname.text.toString()
            if (username.isEmpty()){
                binding.editTextUsername.error = "Username tidak boleh kosong"
                binding.editTextUsername.requestFocus()
            }else if(password.isEmpty()){
                binding.editTextPassword.error = "Password tidak boleh kosong"
                binding.editTextPassword.requestFocus()
            }else if(confirmPass.isEmpty()){
                binding.editTextConfirmPass.error = "Confirm password tidak boleh kosong"
                binding.editTextConfirmPass.requestFocus()
            }else if(confirmPass != password){
                binding.editTextConfirmPass.error = "Confirm password tidak cocok"
                binding.editTextConfirmPass.requestFocus()
            }else if(fullname.isEmpty()){
                binding.editTextFullname.error = "Fullname tidak boleh kosong"
                binding.editTextFullname.requestFocus()
            }else{
                var regrisSuccess : String = "Regristrasi Berhasil "
                Toast.makeText(this, regrisSuccess + username , Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("USERNAME", username)
                intent.putExtra("PASSWORD", password)
                startActivity(intent)
//                this.finish() menutup activity ini


            }
        }
    }
}