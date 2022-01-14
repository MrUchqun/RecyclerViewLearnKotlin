package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.BasicAdapter

class ToolbarScrollActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_scroll)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_toolbar_scroll)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BasicAdapter(context,RecyclerBasicActivity().getMembersList())
    }
}