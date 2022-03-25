package com.example.mobiloitte_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiloitte_project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // intent from login to sign up
        binding.txtSignUp.setOnClickListener {
            Intent(this, SignUpActivity::class.java).also {
                startActivity(it)
            }
        }

        // intent from login to main
        binding.btnLogin.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }

    }
}