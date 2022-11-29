package com.example.bricapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ProgramView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.program_view)

        var newsTitle: String? = intent.getStringExtra("newsTitle")
        var newsDesc: String? = intent.getStringExtra("newsDesc")
        var newsId: Int? = intent.getIntExtra("newsId", 0)

        var closeProgramBtn: Button = findViewById(R.id.closeProgramBtn)
        var registerProgramBtn: Button = findViewById(R.id.registerProgramBtn)
        var programTitle: TextView = findViewById(R.id.programTitleText)
        var programDesc: TextView = findViewById(R.id.programDescText)


        programTitle.text = newsTitle
        programDesc.text = newsDesc + " news ID: " + newsId

        //TODO: Register user for event
        registerProgramBtn.setOnClickListener {
            finish()
        }

        closeProgramBtn.setOnClickListener {
            finish()
        }

    }
}