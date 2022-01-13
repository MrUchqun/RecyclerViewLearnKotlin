package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.OnClickAdapter
import com.example.recyclerviewlearn.model.User

class OnClickListenerActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_click_listener)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_on_click)
        recyclerView.layoutManager = LinearLayoutManager(context)
        refreshAdapter(getUsers())
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        recyclerView.adapter = OnClickAdapter(context,users)
    }

    private fun getUsers(): ArrayList<User> {
        val users: ArrayList<User> = ArrayList()
        for (i in 1..20){
            users.add(User(R.drawable.im_botirov_bekhruzbek,"Botirov Bekhruzbek"))
        }
        return users
    }
}