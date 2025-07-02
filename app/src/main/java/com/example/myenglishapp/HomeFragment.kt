package com.example.myenglishapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myenglishapp.R
import com.example.myenglishapp.adapter.TopicAdapter
import com.example.myenglishapp.Topic

class HomeFragment : Fragment() {

    //before doing the following things we must have created the tag of RecyclerView inside fragment_home.xml
    private lateinit var recyclerView: RecyclerView
    private val topicList = listOf(
        Topic("Grammar"), //"Topic" is the model class(data class)
        Topic("Sentence Patterns"),
        Topic("Phrasal Verbs"),
        Topic("Idioms"),
        Topic("Tenses")
    )
    //we can see the above parts are private variables
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.topicRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TopicAdapter(topicList, requireContext())
        return view
    }
}

