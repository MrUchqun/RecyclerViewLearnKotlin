package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.GridViewAdapter
import com.example.recyclerviewlearn.model.User
import java.util.ArrayList

class GridViewActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_grid_view)
        recyclerView.layoutManager = GridLayoutManager(context,3)
        recyclerView.adapter = GridViewAdapter(context,getUsers())
    }

    private fun getUsers(): ArrayList<User> {
        val users = ArrayList<User>()
        for (i in 1..30){
            users.add(User(R.drawable.im_acc,"Mr. Bobur"))
        }
        return users
    }
}