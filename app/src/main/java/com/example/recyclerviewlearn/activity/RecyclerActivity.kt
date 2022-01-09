package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.RecyclerAdapter
import com.example.recyclerviewlearn.model.User
import java.util.ArrayList

class RecyclerActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler)
        recyclerView.layoutManager = GridLayoutManager(context,1)

        val members: ArrayList<User> = ArrayList<User>()
        val user = User(R.drawable.im_acc,"Tomas Roy")

        addUser(members,user)
        refreshAdapter(members)
    }

    private fun addUser(members: ArrayList<User>, user: User) {
        for (i in 0..20){
            members.add(user)
        }
    }

    private fun refreshAdapter(members: ArrayList<User>) {
        val adapter = RecyclerAdapter(context,members)
        recyclerView.adapter = adapter
    }
}