package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.ChildView
import com.example.recyclerviewlearn.model.User

class PageViewAdapter(var context: Context, var arrayList: ArrayList<ChildView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_page_view,parent,false)
        return PageViewHolder(view)
    }

    class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_page_view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val childView = arrayList[position]
        if (holder is PageViewHolder){
            val textView = holder.textView
            textView.text = childView.text
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}