package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.BasicAdapter

class RecyclerViewAnimActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_anim)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_anim)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_fall_down)
        recyclerView.adapter = BasicAdapter(context,RecyclerBasicActivity().getMembersList())
    }
}