package com.example.recyclerviewlearn.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.recyclerviewlearn.R

class MainActivity : AppCompatActivity() {

    private lateinit var buttonBasicAdapter: Button
    private lateinit var buttonMultipleAdapter: Button
    private lateinit var buttonHeaderFooter: Button
    private lateinit var buttonLoadingMore: Button
    private lateinit var buttonInsideRecycler: Button
    private lateinit var buttonNestedScroll: Button
    private lateinit var buttonGridView: Button
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        context = this@MainActivity
        buttonBasicAdapter = findViewById(R.id.btn_basic_adapter)
        buttonBasicAdapter.setOnClickListener {
            callRecyclerBasicActivity()
        }

        buttonMultipleAdapter = findViewById(R.id.btn_multiple_adapter)
        buttonMultipleAdapter.setOnClickListener {
            callRecyclerMultipleActivity()
        }

        buttonHeaderFooter = findViewById(R.id.btn_header_footer)
        buttonHeaderFooter.setOnClickListener {
            callHeaderFooterActivity()
        }

        buttonLoadingMore = findViewById(R.id.btn_loading_more)
        buttonLoadingMore.setOnClickListener {
            callLoadingMoreActivity()
        }

        buttonInsideRecycler = findViewById(R.id.btn_inside_recycler)
        buttonInsideRecycler.setOnClickListener {
            callInsideRecyclerViewActivity()
        }

        buttonNestedScroll = findViewById(R.id.btn_nested_scroll)
        buttonNestedScroll.setOnClickListener {
            callNestedScrollViewActivity()
        }

        buttonGridView = findViewById(R.id.btn_grid_view)
        buttonGridView.setOnClickListener {
            callGridViewActivity()
        }
    }

    private fun callGridViewActivity() {
        val intent = Intent(context, GridViewActivity::class.java)
        startActivity(intent)
    }

    private fun callNestedScrollViewActivity() {
        val intent = Intent(context, NestedScrollViewActivity::class.java)
        startActivity(intent)
    }

    private fun callInsideRecyclerViewActivity() {
        val intent = Intent(context, InsideRecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun callLoadingMoreActivity() {
        val intent = Intent(context,LoadingMoreActivity::class.java)
        startActivity(intent)
    }

    private fun callHeaderFooterActivity() {
        val intent = Intent(context, HeaderFooterActivity::class.java)
        startActivity(intent)
    }

    private fun callRecyclerMultipleActivity() {
        val intent = Intent(context, RecyclerMultipleActivity::class.java)
        startActivity(intent)
    }

    private fun callRecyclerBasicActivity() {
        val intent = Intent(context, RecyclerBasicActivity::class.java)
        startActivity(intent)
    }

}