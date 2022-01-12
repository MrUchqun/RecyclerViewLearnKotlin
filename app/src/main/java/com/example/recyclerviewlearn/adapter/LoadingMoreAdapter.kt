package com.example.recyclerviewlearn.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.listener.OnBottomReachedListener
import com.example.recyclerviewlearn.model.User

class LoadingMoreAdapter(var context: Context, private var users: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER_VIEW = 0
    private val TYP_FOOTER_VIEW = 1

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(users: ArrayList<User>){
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_HEADER_VIEW){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_header_view,parent,false)
            return HeaderFooterAdapter.HeaderViewHolder(view)
        }

        if (viewType == TYP_FOOTER_VIEW){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_footer_view,parent,false)
            return HeaderFooterAdapter.FooterViewHolder(view)
        }

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
        return UserViewHolder(view)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.iv_acc_photo)
        val textView: TextView = view.findViewById(R.id.tv_acc_name)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (position == users.size - 1){
//            listener.onBottomReached(position)
//        }

        val user : User = users[position]
        if (holder is UserViewHolder) {
            val imageView = holder.imageView
            val textView = holder.textView
            imageView.setImageResource(user.profile)
            textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER_VIEW
            users.size - 1 -> TYP_FOOTER_VIEW
            else -> 2
        }
    }
}