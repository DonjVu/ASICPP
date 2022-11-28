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

//This class controls how the "recyclerView" works on landing_page.xml
//the recycler view holds multiple instances of news_cardview.xml
class LandingPageRecyclerAdapter: RecyclerView.Adapter<LandingPageRecyclerAdapter.ViewHolder>(){

    private var newsTitles = arrayOf<String>()
    private var newsDescs = arrayOf<String>()
    init{
        getData()
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
        holder.newsTitle.text = newsTitles[position]
        holder.newsDesc.text = newsDescs[position]
    }

    //TODO: call database and store data about news titles and descriptions
    fun getData(){
        newsTitles = arrayOf("News #1", "News #2", "News #3", "News #4", "News #4", "News #4", "News #4")
        newsDescs = arrayOf("Example description #1", "Example description #2", "Example description #3", "Example description #4", "Example description #4", "Example description #4", "Example description #4")
    }


    //This class holds the data for one element in the recycler view
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsTitle: TextView
        var newsDesc: TextView

        init{
            newsTitle = itemView.findViewById(R.id.programTitleText)
            newsDesc = itemView.findViewById(R.id.programDescText)
            itemView.setOnClickListener{
            }
        }


    }


}