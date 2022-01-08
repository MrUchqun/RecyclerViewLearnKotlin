package com.example.recyclerviewlearn.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.recyclerviewlearn.R

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCallView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        buttonCallView = findViewById(R.id.btn_call_view)
        buttonCallView.setOnClickListener {
            callRecyclerView()
        }
    }

    private fun callRecyclerView() {
        val intent = Intent(this@MainActivity, RecyclerActivity::class.java)
        startActivity(intent)
    }

}