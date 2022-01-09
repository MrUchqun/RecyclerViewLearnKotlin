package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.User

class MultipleAdapter(var context: Context, var members: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ONLINE: Int = 1
    private val OFFLINE: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ONLINE){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
            return BasicAdapter.MemberViewHolder(view)
        }

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_false,parent,false)
        return BasicAdapter.MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user: User = members[position]
        if (holder is BasicAdapter.MemberViewHolder) {
            val imageView = holder.imageView
            val textView = holder.textView

            imageView.setImageResource(user.profile)
            textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (members[position].isOnline) ONLINE else OFFLINE
    }
}
