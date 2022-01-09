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