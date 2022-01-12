package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.NestedScrollAdapter
import com.example.recyclerviewlearn.model.User

class NestedScrollViewActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_view)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_in_nested_scroll)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.adapter = NestedScrollAdapter(context, getUsers())
    }

    private fun getUsers(): ArrayList<User> {
        val users = ArrayList<User>()
        for (i in 1..20){
            users.add(User(R.drawable.im_acc,"Botirbek Sadullayev"))
        }
        return users
    }
}