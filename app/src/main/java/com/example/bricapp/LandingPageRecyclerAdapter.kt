package com.example.bricapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat.startActivity
import java.util.Calendar

//This class controls how the "recyclerView" works on landing_page.xml
//the recycler view holds multiple instances of news_cardview.xml
class LandingPageRecyclerAdapter: RecyclerView.Adapter<LandingPageRecyclerAdapter.ViewHolder>(){

    private var newsTitles = ArrayList<String>()
    private var newsDescs = ArrayList<String>()
    init{
        updateData()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LandingPageRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsTitles.size
    }

    override fun onBindViewHolder(holder: LandingPageRecyclerAdapter.ViewHolder, position: Int) {
        holder.newsTitle.text = newsTitles.get(position)
        holder.newsDesc.text = newsDescs.get(position)

    }


    public fun updateData(){
        var currentTime: Calendar = Calendar.getInstance()
        updateData(currentTime.get(Calendar.DAY_OF_MONTH), currentTime.get(Calendar.MONTH), currentTime.get(Calendar.YEAR))
    }

    //TODO: call database and store data about news titles, descriptions, and ids
    public fun updateData(day: Int, month: Int, year: Int){
        newsTitles.clear()
        newsDescs.clear()

        newsTitles.add("a")
        newsDescs.add("desc a")
        newsTitles.add("b")
        newsDescs.add("desc b")
        newsTitles.add("c")
        newsDescs.add("desc c")
        newsTitles.add("d")
        newsDescs.add("desc d")
        this.notifyDataSetChanged()
    }


    //This class holds the data for one element in the recycler view
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsTitle: TextView
        var newsDesc: TextView
        var viewProgramBtn: Button
        var newsId: Int

        init{
            newsTitle = itemView.findViewById(R.id.programTitleText)
            newsDesc = itemView.findViewById(R.id.programDescText)
            viewProgramBtn = itemView.findViewById(R.id.viewProgramBtn)
            //TODO: Get newsId from database
            newsId = 1

            itemView.setOnClickListener{
            }

            viewProgramBtn.setOnClickListener{
                val programViewIntent = Intent(super.itemView.context, ProgramView::class.java)
                programViewIntent.putExtra("newsTitle", newsTitle.text)
                programViewIntent.putExtra("newsDesc", newsDesc.text)
                programViewIntent.putExtra("newsId", newsId)
                startActivity(super.itemView.context, programViewIntent, null)
            }

        }


    }


}