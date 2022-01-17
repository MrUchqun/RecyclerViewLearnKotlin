package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.PinterestCellsAdapter
import com.example.recyclerviewlearn.helper.SpacesItemDecoration
import com.example.recyclerviewlearn.model.ChildView
import java.util.ArrayList

class PinterestCellsActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinterest_cells)
        initView()
    }

    private fun initView() {
        context = this
        recyclerView = findViewById(R.id.view_recycler_pinterest)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))
        recyclerView.adapter = PinterestCellsAdapter(context,getItems())
    }

    private fun getItems(): ArrayList<ChildView> {
        val items = ArrayList<ChildView>()
        for (i in 0..20){
            items.add(ChildView("Item $i"))
        }
        return items
    }
}