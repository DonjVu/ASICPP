package com.example.bricapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar

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
        var calendarView: CalendarView = findViewById(R.id.calendarView)
        var currentTime: Calendar = Calendar.getInstance()
        var calendarDay = currentTime.get(Calendar.DAY_OF_MONTH)
        var calendarMonth = currentTime.get(Calendar.MONTH)
        var calendarYear = currentTime.get(Calendar.YEAR)


        getBarcodeBtn.setOnClickListener(){

            val barcodePopUp = BarcodeActivity()
            barcodePopUp.show(supportFragmentManager, "barcodePopUp")

        }


        calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
            calendarDay = dayOfMonth
            calendarMonth = month + 1
            calendarYear = year
            (adapter as LandingPageRecyclerAdapter).updateData(calendarDay, calendarMonth, calendarYear)
            //Log.i("eee", "" + calendarDay + " " + calendarMonth + " " + calendarYear)
        })


    }


}