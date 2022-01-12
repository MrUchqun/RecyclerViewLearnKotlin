package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.ChildView

class InsideChildAdapter(val context: Context, val arrayList: ArrayList<ChildView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_child_view,parent,false)
        return ChildViewHolder(view)
    }

    class ChildViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_child_item)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: ChildView = arrayList[position]
        if (holder is ChildViewHolder){
            val textView: TextView = holder.textView
            textView.text = item.text
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}