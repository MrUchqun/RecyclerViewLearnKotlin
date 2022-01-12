package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.ChildView
import com.example.recyclerviewlearn.model.User

class InsideRecyclerViewAdapter(var context: Context, var users: ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_VIEW_USER = 0
    private val TYPE_VIEW_LIST = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_VIEW_LIST){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_inside_recycler_view,parent,false)
            return InsideRecyclerViewHolder(view)
        }

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user_view_true,parent,false)
        return LoadingMoreAdapter.UserViewHolder(view)

    }

    class InsideRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.view_recycler_child)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val user = users[position]

        if (holder is InsideRecyclerViewHolder){
            val recyclerView: RecyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            refreshAdapter(recyclerView, getChildView())
        }

        if (holder is LoadingMoreAdapter.UserViewHolder){
            val textView: TextView = holder.textView
            val imageView: ImageView = holder.imageView

            textView.text = user.fullName
            imageView.setImageResource(user.profile)
        }
    }

    private fun refreshAdapter(recyclerView: RecyclerView, childView: ArrayList<ChildView>) {
        recyclerView.adapter = InsideChildAdapter(context,childView)
    }

    private fun getChildView(): ArrayList<ChildView> {
        val arrayList = ArrayList<ChildView>()
        for (i in 1..10){
            arrayList.add(ChildView("$i. There is child item of RecyclerView"))
        }
        return arrayList
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 4 == 0 && position != 0) TYPE_VIEW_LIST else TYPE_VIEW_USER
    }
}