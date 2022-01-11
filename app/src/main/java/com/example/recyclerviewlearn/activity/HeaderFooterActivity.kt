package com.example.recyclerviewlearn.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.R
import com.example.recyclerviewlearn.adapter.HeaderFooterAdapter
import com.example.recyclerviewlearn.model.User

class HeaderFooterActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var headerFooterView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header_footer)
        initView()
    }

    private fun initView() {
        context = this
        headerFooterView = findViewById(R.id.view_header_footer)
        headerFooterView.layoutManager = GridLayoutManager(context,1)
        refreshAdapter(getMembersList())
    }

    private fun refreshAdapter(membersList: ArrayList<User>) {
        headerFooterView.adapter = HeaderFooterAdapter(context,membersList)
    }

    private fun getMembersList(): ArrayList<User> {
        val membersList : ArrayList<User> = ArrayList()
        membersList.add(User())

        for (i in 1..14)
            if (i % 3 == 0) membersList.add(User(R.drawable.im_acc,"Leo_Messi_$i"))
            else membersList.add(User(R.drawable.im_acc,"Cristiano_Ronaldo_$i"))

        membersList.add(User())
        return membersList
    }
}