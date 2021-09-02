package ui.recyclerView

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import api.models.Word
import com.example.testdic.R
import com.example.testdic.WordActivity


class RecyclerViewAdapter(private val context: Context, private val wordList: List<Word>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var wordTextView: TextView = itemView.findViewById(R.id.wordTextView)
        var tranlsationTextView: TextView = itemView.findViewById(R.id.translationTextView)

        fun bind(position: Int){
            itemView.setOnClickListener {
                startActivity(it.context, Intent(it.context, WordActivity::class.java).putExtra("position", position), Bundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_word_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = wordList[position]
        holder.bind(position)

        holder.wordTextView.text = word.text
        holder.tranlsationTextView.text = word.meanings[0].translation.text

    }

    override fun getItemCount(): Int {
        return wordList.size
    }

}