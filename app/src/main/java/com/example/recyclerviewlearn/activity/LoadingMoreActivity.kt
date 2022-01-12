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
    private lateinit var membersList: ArrayList<User>
    private var j = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_more)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_loading_more)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        membersList = ArrayList()
        refreshAdapter(getUsers(membersList))
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = LoadingMoreAdapter(context,users)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)){
                    Toast.makeText(context,"There is bottom",Toast.LENGTH_SHORT).show()
                }
            }
        })
        recyclerView.adapter = adapter
    }

    private fun getUsers(membersList : ArrayList<User> ): ArrayList<User> {
        membersList.add(User())

        for (i in 1..14)
            if (i % 3 == 0) membersList.add(User(R.drawable.im_acc,"Leo_Messi_${j++}"))
            else membersList.add(User(R.drawable.im_acc,"Cristiano_Ronaldo_${j++}"))

        membersList.add(User())
        return membersList
    }
}