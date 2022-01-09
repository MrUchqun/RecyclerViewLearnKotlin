package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.BasicAdapter
import com.example.recyclerviewlearn.model.User
import java.util.ArrayList

class RecyclerBasicActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_basic)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        refreshAdapter(getMembersList())
    }

    private fun getMembersList(): ArrayList<User> {
        val members: ArrayList<User> = ArrayList<User>()
        for (i in 0..14){
            members.add(User(R.drawable.im_acc,"JackRicher_${i+1}"))
        }
        return members
    }

    private fun refreshAdapter(members: ArrayList<User>) {
        val adapter = BasicAdapter(context,members)
        recyclerView.adapter = adapter
    }
}