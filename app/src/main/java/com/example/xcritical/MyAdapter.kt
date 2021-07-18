package com.example.xcritical

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class MyAdapter(private val newsList: ArrayList<RcData>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val frameRc : ImageView = itemView.findViewById(R.id.frameRc)
        val textDate : TextView = itemView.findViewById(R.id.textDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.frameRc.setImageResource(currentItem.titleImage)
        holder.textDate.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}