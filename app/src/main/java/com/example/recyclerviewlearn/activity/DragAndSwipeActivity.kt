package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.DragSwipeAdapter
import com.example.recyclerviewlearn.helper.SimpleTouchHelperCallback
import com.example.recyclerviewlearn.model.User

class DragAndSwipeActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_and_swipe)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_drag_swim)
        recyclerView.layoutManager = LinearLayoutManager(context)
        refreshAdapter(RecyclerBasicActivity().getMembersList())
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = DragSwipeAdapter(context, users)
        recyclerView.adapter = adapter
        val callback: ItemTouchHelper.Callback = SimpleTouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
    }
}