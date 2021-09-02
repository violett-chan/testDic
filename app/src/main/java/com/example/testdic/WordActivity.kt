package com.example.testdic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import api.models.Word
import kotlinx.android.synthetic.main.activity_word.*
import ui.recyclerView.MeaningsRecyclerViewAdapter

class WordActivity() : AppCompatActivity() {

    private lateinit var currentWord: Word
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MeaningsRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        currentWord = wordList[intent.getIntExtra("position", 0)]
        mainWord.text = currentWord.text
        transcriptionTextView.text = currentWord.meanings[0].transcription
        setupRecyclerView()
        loadMeanings()
    }

    private fun setupRecyclerView(){
        meaningsRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        meaningsRecyclerView.layoutManager = layoutManager
    }

    private fun loadMeanings(){
        adapter = MeaningsRecyclerViewAdapter(baseContext, currentWord.meanings)
        meaningsRecyclerView.adapter = adapter
    }
}