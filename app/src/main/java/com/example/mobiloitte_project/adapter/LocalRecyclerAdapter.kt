package com.example.mobiloitte_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiloitte_project.R
import com.example.mobiloitte_project.model.ModelClass

class LocalRecyclerAdapter(val context: Context, val itemList: ArrayList<ModelClass>): RecyclerView.Adapter<LocalRecyclerAdapter.LocalViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.local_recycler, parent, false)
        return LocalViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocalViewHolder, position: Int) {
        val text = itemList[position]
        holder.listItemView.text = text.name
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class LocalViewHolder(view : View):RecyclerView.ViewHolder(view) {

        val listItemView : TextView = view.findViewById(R.id.txtLocalRecycler)

    }

}