package com.example.bricapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception
import java.lang.NullPointerException

class LoginActivity : AppCompatActivity() {
    private val SHARED_PREF = "bricapp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        var settings = this.getSharedPreferences(SHARED_PREF, 0)
        var editor = settings.edit()

        val loginBtn: Button = findViewById (R.id.loginBtn)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        //TODO: DONT FORGET TO REMOVE THESE THEY CLEAR THE STORED LOGIN TOKEN
        editor.clear()
        editor.apply()

        //go to landing page immediately if there is a login token
        if(checkLogin(settings)){
            goToLandingPage(getTokenFromMemory(settings))
        }


        //Move to landing page once login button pressed
        loginBtn.setOnClickListener(){

            if(login(usernameEditText.text.toString(), passwordEditText.text.toString())){
                generateToken(editor,usernameEditText.text.toString())
                goToLandingPage(getTokenFromMemory(settings))
            } else{
                //TODO: show that login failed
            }

        }


        //Move to sign up page once sign up button pressed
        signUpBtn.setOnClickListener(){

            val signUpIntent = Intent(this, SignUpActivity::class.java)
            //move to landing page
            startActivity(signUpIntent);

        }


    }

    //checks if there is a login token
    private fun checkLogin(settings: SharedPreferences): Boolean {

        //If the login token does not exist or is blank, return false
        var token = settings.getString("loginToken", "")
        return !token.equals("")

    }

    //store a login token into shared preferences
    private fun storeToken(editor: SharedPreferences.Editor, token: String){

        editor.putString("loginToken", token)
        editor.apply()

    }

    //get the actual token from shared preferences
    private fun getTokenFromMemory(settings: SharedPreferences): String{
        try{
            return settings.getString("loginToken", "")!!
        } catch (e: NullPointerException){
            return ""
        }
    }

    private fun goToLandingPage(loginToken: String){
        val landingPageIntent = Intent(this, LandingPageActivity::class.java)
        startActivity(landingPageIntent);
    }

    //TODO: call database to login and return true if login was valid
    private fun login(username: String, password: String): Boolean{
        return CppAccountDB.isSignInValid(username, password)
    }

    //TODO: generate a login token after function "login" was called and store it in shared preferences
    private fun generateToken(editor: SharedPreferences.Editor, username: String){
        storeToken(editor, ""+CppAccountDB.getStudentIDFromName(username))
    }

}