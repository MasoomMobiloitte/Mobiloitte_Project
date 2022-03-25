package com.example.mobiloitte_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiloitte_project.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // Adding scrollable behavior in bio field
        binding.etBio.setOnTouchListener(OnTouchListener { v, event ->
            if (binding.etBio.hasFocus()) {
                v.parent.requestDisallowInterceptTouchEvent(true)
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_SCROLL -> {
                        v.parent.requestDisallowInterceptTouchEvent(false)
                        return@OnTouchListener true
                    }
                }
            }
            false
        })


        // adding validations
//        val name = binding.etFullName.text.toString().trim()
//        val userName = binding.etUserName.text.toString().trim()
//        val email = binding.etEmailAddress.text.toString().trim()
//        val pass = binding.etPassword.toString().trim()
//        val confirmPass = binding.etConfirmPassword.toString().trim()
//        val bio = binding.etBio.text.toString().trim()
//        val instaLink = binding.etInstagramLink.toString().trim()
//        val twitterLink = binding.etTwitterLink.toString().trim()
//        val facebookLink = binding.etFacebookLink.toString().trim()
//        val youTubeLink = binding.etYoutubeLink.toString().trim()
//        validateName()

    }

//    fun validateName():Boolean{
//
//        val name = binding.etFullName.text.toString().trim()
//        if(name.isEmpty()){
//            binding.etFullName.setError("Please enter your full name")
//        }
//
//        return true
//    }

}