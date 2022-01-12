package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.LoadingMoreAdapter
import com.example.recyclerviewlearn.listener.OnBottomReachedListener
import com.example.recyclerviewlearn.model.User
import com.google.android.material.snackbar.Snackbar

class LoadingMoreActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_more)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_loading_more)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        refreshAdapter(getUsers())
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = LoadingMoreAdapter(context,users)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)){
                    if (count < 5){
                        adapter.setUsers(getUsers())
                        count++
                    }
                    else Toast.makeText(context,"There is bottom",Toast.LENGTH_SHORT).show()
                }
            }
        })
        recyclerView.adapter = adapter
    }

    private fun getUsers(): ArrayList<User> {
        val membersList = ArrayList<User>()
        membersList.add(User(R.drawable.im_acc,"Leo Messi"))
        for (i in 1..18)
            if (i % 3 == 0) membersList.add(User(R.drawable.im_acc,"Leo Messi"))
            else membersList.add(User(R.drawable.im_acc,"Cristiano Ronaldo"))
        membersList.add(User(R.drawable.im_acc,"Cristiano Ronaldo"))
        return membersList
    }
}