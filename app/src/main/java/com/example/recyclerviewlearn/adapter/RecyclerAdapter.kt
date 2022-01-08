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

class RecyclerAdapter(var context: Context, var members: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view,parent,false)
        return MemberViewHolder(view)
    }

    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_acc_photo)
        val textView: TextView = itemView.findViewById(R.id.tv_acc_name)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user : User = members[position]
        if (holder is MemberViewHolder) {
            val imageView = holder.imageView
            val textView = holder.textView

            imageView.setImageResource(user.profile)
            textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }
}