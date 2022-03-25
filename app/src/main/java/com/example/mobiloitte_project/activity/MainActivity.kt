package com.example.mobiloitte_project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mobiloitte_project.R
import com.example.mobiloitte_project.databinding.ActivityMainBinding
import com.example.mobiloitte_project.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // add title in app
        setupToolbar()

        // cll default fragment
        openHome()


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> {
                    Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HomeFragment())
                        .commit()
                }

            }
            return@setOnItemSelectedListener true

        }
    }

    fun openHome(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, HomeFragment())
            .commit()
        supportActionBar?.title = "Home"
    }


    // added title function
    fun setupToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Home"
    }

    // added menu icons on toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

}