package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.User

class NestedScrollAdapter(var context: Context, var users: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
        return LoadingMoreAdapter.UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        val textView = (holder as LoadingMoreAdapter.UserViewHolder).textView
        val imageView = (holder as LoadingMoreAdapter.UserViewHolder).imageView

        textView.text = user.fullName
        imageView.setImageResource(user.profile)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}