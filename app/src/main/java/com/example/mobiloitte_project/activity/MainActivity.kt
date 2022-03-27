package com.example.mobiloitte_project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.mobiloitte_project.R
import com.example.mobiloitte_project.databinding.ActivityMainBinding
import com.example.mobiloitte_project.fragment.ChatFragment
import com.example.mobiloitte_project.fragment.HomeFragment
import com.example.mobiloitte_project.fragment.MessageFragment
import com.example.mobiloitte_project.fragment.ProfileFragment

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
                    openHome()
                }

                R.id.msg -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MessageFragment())
                        .commit()
                    supportActionBar?.title = "Message"
                }

                R.id.add -> {
                    Toast.makeText(this, "add button clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.chat -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ChatFragment())
                        .commit()
                    supportActionBar?.title = "Chat Screen"
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ProfileFragment())
                        .commit()
                    supportActionBar?.title = "Profile"
                }

            }
            return@setOnItemSelectedListener true
        }
    }

    // open home as default screen
    fun openHome(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, HomeFragment())
            .addToBackStack("home")
            .commit()
        supportActionBar?.title = "Home"
    }

    // added title function
    fun setupToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // change hamburger icon with profile icon
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_profile)
    }

    // added menu icons on toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // changing back pressed functionality
    override fun onBackPressed() {
        val frag =  supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is HomeFragment -> openHome()
            else -> super.onBackPressed()
            }
        }


    }
