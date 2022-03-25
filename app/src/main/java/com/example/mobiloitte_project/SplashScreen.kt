package com.example.mobiloitte_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        lifecycleScope.launch(Dispatchers.Main){
            delay(3000)

            Intent(this@SplashScreen, LoginActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }

//        Old way to create Splash Screen
//            Handler().postDelayed({
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}