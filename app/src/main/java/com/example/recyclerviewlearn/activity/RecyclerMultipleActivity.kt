package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.MultipleAdapter
import com.example.recyclerviewlearn.model.User

class RecyclerMultipleActivity : AppCompatActivity() {

    private lateinit var recyclerViewMultiple: RecyclerView
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_multiple)
        initView()
    }

    private fun initView() {
        context = this
        recyclerViewMultiple = findViewById(R.id.view_recycler_multiple)
        recyclerViewMultiple.layoutManager = GridLayoutManager(context,1)
        refreshAdapter(getMemberList())
    }

    private fun getMemberList(): ArrayList<User> {
        val members: ArrayList<User> = ArrayList()
        for (i in 1..14)
            if (i % 3 == 0) members.add(User(R.drawable.im_acc,"Leo Messi $i",true))
            else members.add(User(R.drawable.im_acc,"Cristiano Ronaldo $i"))

        return members
    }

    private fun refreshAdapter(members: ArrayList<User>) {
        val adapter = MultipleAdapter(context,members)
        recyclerViewMultiple.adapter = adapter
    }
}