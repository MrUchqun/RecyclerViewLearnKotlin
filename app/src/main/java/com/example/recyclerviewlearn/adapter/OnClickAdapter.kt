package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.User

class OnClickAdapter(var context: Context, var list : ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_on_click_about,parent,false)
        return ClickUserViewHolder(view)
    }

    class ClickUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val clickLayout: LinearLayout = view.findViewById(R.id.layout_click)
        val aboutLayout: LinearLayout = view.findViewById(R.id.layout_about)
        val imageView: ImageView = view.findViewById(R.id.iv_acc_photo_click_view)
        val textView: TextView = view.findViewById(R.id.tv_acc_name_click_view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = list[position]
        if (holder is ClickUserViewHolder){
            val imageView: ImageView = holder.imageView
            val textView: TextView = holder.textView
            val clickLayout: LinearLayout = holder.clickLayout
            val aboutLayout: LinearLayout = holder.aboutLayout

            imageView.setImageResource(user.profile)
            textView.text = user.fullName

            clickLayout.setOnClickListener {
                if (aboutLayout.visibility == View.GONE)
                aboutLayout.visibility = View.VISIBLE
                else aboutLayout.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}