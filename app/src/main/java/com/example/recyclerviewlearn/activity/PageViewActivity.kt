package com.example.recyclerviewlearn.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.PageViewAdapter
import com.example.recyclerviewlearn.model.ChildView

class PageViewActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_view)
        initView()
        refreshAdapter(getChildViews())
    }

    private fun refreshAdapter(childViews: ArrayList<ChildView>) {
        recyclerView.adapter = PageViewAdapter(context, childViews)
    }

    private fun getChildViews(): ArrayList<ChildView> {
        val childViews = ArrayList<ChildView>()
        for (i in 1..10){
            childViews.add(ChildView("PageView $i"))
        }
        return childViews
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_page_view)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val snapHelper : SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnClickListener(object : RecyclerView.OnScrollListener(),
            View.OnClickListener {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val activePosition = layoutManager.findFirstVisibleItemPosition()
                if (activePosition == RecyclerView.NO_POSITION) return
            }

            override fun onClick(p0: View?) {
                startActivity(Intent(context,MainActivity::class.java))
                finish()
            }
        })
    }
}