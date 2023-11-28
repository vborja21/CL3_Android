package com.example.examenfinal.Models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal.Entity.videos
import com.example.examenfinal.R

class CustomerAdapterVideo (private var mList: List<videos>, private val onItemClick: (String) -> Unit): RecyclerView.Adapter<CustomerAdapterVideo.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pelicula: TextView = itemView.findViewById(R.id.Pelicula)
        val descripcion: TextView = itemView.findViewById(R.id.Descri)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listadop, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = mList[position]
        holder.pelicula.text = itemViewModel.title
        holder.descripcion.text = itemViewModel.title
        holder.itemView.setOnClickListener {
            val videoUrl = mList[position].sources.firstOrNull()
            if (videoUrl != null) {
                onItemClick(videoUrl)
            }
        }
    }

    fun setData(newList: List<videos>) {
        mList = newList
        notifyDataSetChanged()
    }
    }



