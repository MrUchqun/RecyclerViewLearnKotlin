package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.User

class GridViewAdapter(var context: Context, var users: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_view,parent,false)
        return LoadingMoreAdapter.UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        if (holder is LoadingMoreAdapter.UserViewHolder){
            val imageView: ImageView = holder.imageView
            val textView: TextView = holder.textView

            imageView.setImageResource(user.profile)
            textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}