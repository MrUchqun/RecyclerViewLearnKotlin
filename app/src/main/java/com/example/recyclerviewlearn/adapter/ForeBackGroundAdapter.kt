package com.example.recyclerviewlearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.model.ChildView
import com.example.recyclerviewlearn.model.User

class ForeBackGroundAdapter(val context: Context, val users: ArrayList<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_fore_back_ground,parent,false)
        return ForeBackGroundHolder(view)
    }

    class ForeBackGroundHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foreGround: LinearLayout = view.findViewById(R.id.view_foreground)
        val backGround: LinearLayout = view.findViewById(R.id.view_background)
        val imageView : ImageView = view.findViewById(R.id.iv_acc_photo_fore)
        val textView: TextView = view.findViewById(R.id.tv_acc_name_fore)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users[position]
        if (holder is ForeBackGroundHolder){
            holder.imageView.setImageResource(user.profile)
            holder.textView.text = user.fullName
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun removeItem(position: Int){
        users.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(user: User, position: Int){
        users.add(user)
        notifyItemInserted(position)
    }
}