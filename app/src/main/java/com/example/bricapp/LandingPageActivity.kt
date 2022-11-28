package com.example.bricapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandingPageActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<LandingPageRecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)

        val recycler: RecyclerView = findViewById(R.id.calendarRecyclerView)
        layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        adapter = LandingPageRecyclerAdapter()
        recycler.adapter = adapter
        var getBarcodeBtn: Button = findViewById(R.id.barcodeBtn)



        getBarcodeBtn.setOnClickListener(){

            val barcodePopUp = BarcodeActivity()
            barcodePopUp.show(supportFragmentManager, "barcodePopUp")

        }

    }

}