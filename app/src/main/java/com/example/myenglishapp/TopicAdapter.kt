package com.example.myenglishapp.adapter//I think no need to add '.adapter'

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myenglishapp.R
import com.example.myenglishapp.activities.GrammarActivity
import com.example.myenglishapp.Topic

class TopicAdapter(
    private val topics: List<Topic>,
    private val context: Context
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.topic_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.title.text = topic.title
        holder.itemView.setOnClickListener {
            when (topic.title) {
                "Grammar" -> context.startActivity(Intent(context, GrammarActivity::class.java))
                // Add more activities here if needed
            }
        }
    }

    override fun getItemCount() = topics.size
}
