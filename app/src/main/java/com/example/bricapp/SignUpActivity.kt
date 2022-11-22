package com.example.bricapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)


        val createAccountBtn: Button = findViewById (R.id.createAccountBtn)
        val backBtn: Button = findViewById(R.id.signUpBackBtn)


        //Move to landing page activity once create account button is pressed
        //TODO: verify account creation and show a pop up banner to tell user if account was created successfully or not
        createAccountBtn.setOnClickListener(){

            val landingPageIntent = Intent(this, LandingPageActivity::class.java)
            //move to landing page
            startActivity(landingPageIntent)

        }


        //Move back to login page once back button is pressed
        backBtn.setOnClickListener(){
            finish()
        }

    }
}