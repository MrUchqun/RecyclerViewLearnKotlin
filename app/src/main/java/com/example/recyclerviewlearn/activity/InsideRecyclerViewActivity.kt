package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.InsideRecyclerViewAdapter
import com.example.recyclerviewlearn.model.User

class InsideRecyclerViewActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_recycler_view)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_parent)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        refreshAdapter(getUser())
    }

    private fun refreshAdapter(user: ArrayList<User>) {
        recyclerView.adapter = InsideRecyclerViewAdapter(context,user)
    }

    private fun getUser(): ArrayList<User> {
        val users = ArrayList<User>()
        for (i in 1..10){
            users.add(User(R.drawable.im_acc, "Bekhruzbek Botirov $i"))
        }
        return users
    }
}