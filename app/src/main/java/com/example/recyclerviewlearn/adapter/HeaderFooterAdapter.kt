package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.User

class HeaderFooterAdapter (var context: Context, var members:ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER: Int = 0
    private val FOOTER: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HEADER){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_header_view,parent,false)
            return HeaderViewHolder(view)
        } else if (viewType == FOOTER) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_footer_view,parent,false)
            return FooterViewHolder(view)
        }

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
        return BasicAdapter.MemberViewHolder(view)
    }

    class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_footer)
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_header)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user: User = members[position]
        if (holder is BasicAdapter.MemberViewHolder) {
            holder.imageView.setImageResource(user.profile)
            holder.textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return HEADER
        if (position == itemCount - 1) return FOOTER

        return 2
    }
}