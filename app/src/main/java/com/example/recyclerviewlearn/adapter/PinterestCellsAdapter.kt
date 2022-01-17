package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.ChildView
import com.example.recyclerviewlearn.model.User

class PinterestCellsAdapter(val context: Context, val users: ArrayList<ChildView>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pinterest_cells,parent,false)
        return PinterestItemViewHolder(view)
    }

    class PinterestItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.iv_pinterest)
        val textView: TextView = view.findViewById(R.id.tv_pinterest)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        if (holder is PinterestItemViewHolder){
            when {
                position % 3 == 0 -> {
                    holder.imageView.setImageResource(R.drawable.im_acc)
                    holder.textView.text = user.text
                }
                position % 3 == 1 -> {
                    holder.imageView.setImageResource(R.drawable.im_item_1)
                    holder.textView.text = user.text
                }
                else -> {
                    holder.imageView.setImageResource(R.drawable.im_item_2)
                    holder.textView.text = user.text
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}