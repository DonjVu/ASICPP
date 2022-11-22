package com.example.bricapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)


        val loginBtn: Button = findViewById (R.id.loginBtn)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)


        //Move to landing page once login button pressed
        //TODO: verify user login here
        loginBtn.setOnClickListener(){

            val landingPageIntent = Intent(this, LandingPageActivity::class.java)
            //move to landing page
            startActivity(landingPageIntent);

        }


        //Move to sign up page once sign up button pressed
        signUpBtn.setOnClickListener(){

            val signUpPageIntent = Intent(this, SignUpActivity::class.java)
            //move to landing page
            startActivity(signUpPageIntent);

        }


    }
}