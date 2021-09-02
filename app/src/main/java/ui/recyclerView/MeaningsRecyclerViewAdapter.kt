package ui.recyclerView

import android.content.Intent
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import api.models.Meaning
import api.models.Word
import com.example.testdic.R
import com.example.testdic.WordActivity
import com.squareup.picasso.Picasso


class MeaningsRecyclerViewAdapter(private val context: Context, private val meaningList: List<Meaning>): RecyclerView.Adapter<MeaningsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var meaningTTextView: TextView = itemView.findViewById(R.id.meaningTranslationTextView)
        var noteTextView: TextView = itemView.findViewById(R.id.noteTextView)
        var preview: ImageView = itemView.findViewById(R.id.previewImageView)

        fun bind(position: Int){
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_meaning_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meaning = meaningList[position]
        holder.bind(position)

        holder.meaningTTextView.text = meaning.translation.text
        holder.noteTextView.text = meaning.translation.note
        //Picasso.get().load(meaning.previewUrl).into(holder.preview)
        holder.preview.setImageURI(Uri.parse(meaning.previewUrl))  //im dead inside

    }

    override fun getItemCount(): Int {
        return meaningList.size
    }

}