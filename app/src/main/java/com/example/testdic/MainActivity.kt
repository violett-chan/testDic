package com.example.testdic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import api.DictonaryApi
import api.common.Common
import api.models.Word
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ui.recyclerView.RecyclerViewAdapter

lateinit var wordList: List<Word>

class MainActivity : AppCompatActivity() {

    private lateinit var dictonaryApi: DictonaryApi
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dictonaryApi = Common.dictonaryApi

        setupRecyclerView()
        setupOnClickListeners()

    }
    private fun setupOnClickListeners(){
        searchButton.setOnClickListener {
            searchWord(searchEditText.text.toString())
        }
    }

    private fun setupRecyclerView(){
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun searchWord(search: String){
        dictonaryApi.search(search).enqueue(object : Callback<List<Word>>{
            override fun onResponse(call: Call<List<Word>>, response: Response<List<Word>>) {
                //Toast.makeText(this@MainActivity, response.body().toString(), Toast.LENGTH_SHORT).show()
                wordList = response.body() as List<Word>
                loadWords(wordList)
            }

            override fun onFailure(call: Call<List<Word>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ошибка $t", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun loadWords(wordList: List<Word>){
        adapter = RecyclerViewAdapter(baseContext, wordList)
        recyclerView.adapter = adapter
    }
}