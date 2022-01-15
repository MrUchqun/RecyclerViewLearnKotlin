package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.helper.ItemTouchHelperAdapter
import com.example.recyclerviewlearn.model.User
import java.util.*
import kotlin.collections.ArrayList

class DragSwipeAdapter(val context: Context, val users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
        return LoadingMoreAdapter.UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        if (holder is LoadingMoreAdapter.UserViewHolder){
            holder.imageView.setImageResource(user.profile)
            holder.textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(users, i,i+1)
            }
        } else {
            for (i in toPosition until fromPosition){
                Collections.swap(users, i,i+1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        users.removeAt(position)
        notifyItemRemoved(position)
    }

}