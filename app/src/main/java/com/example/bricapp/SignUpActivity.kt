package com.example.bricapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.lang.NullPointerException

class SignUpActivity : AppCompatActivity() {
    private val SHARED_PREF = "bricapp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)

        var settings = this.getSharedPreferences(SHARED_PREF, 0)
        var editor = settings.edit()

        val createAccountBtn: Button = findViewById (R.id.createAccountBtn)
        val backBtn: Button = findViewById(R.id.signUpBackBtn)
        val broncoIdEditText: EditText = findViewById(R.id.enterBroncoIdEditText)
        val usernameEditText: EditText = findViewById(R.id.createUsernameEditText)
        val passwordEditText: EditText = findViewById(R.id.createPasswordEditText)


        //Move to landing page activity once create account button is pressed
        createAccountBtn.setOnClickListener(){

            if(createAccount(broncoIdEditText.text.toString(), usernameEditText.text.toString(), passwordEditText.text.toString())){
                generateToken(editor)
                goToLandingPage(getTokenFromMemory(settings))
            } else{
                //TODO: show that sign up failed
            }

        }


        //Move back to login page once back button is pressed
        backBtn.setOnClickListener(){
            finish()
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

    //TODO: call database to create an account and return true if account can be created
    private fun createAccount(broncoId: String, username: String, password: String): Boolean{
        return true
    }

    //TODO: generate a login token after function "createAccount" was called and store it in shared preferences
    private fun generateToken(editor: SharedPreferences.Editor){
        storeToken(editor, "123")
    }
}