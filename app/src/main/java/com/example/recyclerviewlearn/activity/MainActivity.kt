package com.example.recyclerviewlearn.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.Toolbar
import com.example.recyclerviewlearn.R

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var buttonBasicAdapter: Button
    private lateinit var buttonMultipleAdapter: Button
    private lateinit var buttonHeaderFooter: Button
    private lateinit var buttonLoadingMore: Button
    private lateinit var buttonInsideRecycler: Button
    private lateinit var buttonNestedScroll: Button
    private lateinit var buttonGridView: Button
    private lateinit var buttonPageView: Button
    private lateinit var buttonOnClickList: Button
    private lateinit var buttonToolbarEffect: Button
    private lateinit var buttonAnim: Button
    private lateinit var buttonDragSwipe: Button
    private lateinit var buttonForeground: Button
    private lateinit var buttonPinterest: Button

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

        buttonPageView = findViewById(R.id.btn_page_view)
        buttonPageView.setOnClickListener {
            callPageViewActivity()
        }

        buttonOnClickList = findViewById(R.id.btn_on_click_listener)
        buttonOnClickList.setOnClickListener{
            callOnClickListenerActivity()
        }

        buttonToolbarEffect = findViewById(R.id.btn_toolbar_scroll)
        buttonToolbarEffect.setOnClickListener {
            callToolbarScrollActivity()
        }

        buttonAnim = findViewById(R.id.btn_anim)
        buttonAnim.setOnClickListener {
            callRecyclerViewAnimActivity()
        }

        buttonDragSwipe = findViewById(R.id.btn_drag_swipe)
        buttonDragSwipe.setOnClickListener {
            callDragAndSwipeActivity()
        }

        buttonForeground = findViewById(R.id.btn_fore_back_ground)
        buttonForeground.setOnClickListener {
            callForegroundBackgroundActivity()
        }

        buttonPinterest = findViewById(R.id.btn_pinterest_cells)
        buttonPinterest.setOnClickListener {
            callPinterestCellsActivity()
        }
    }

    private fun callPinterestCellsActivity() {
        val intent = Intent(context, PinterestCellsActivity::class.java)
        startActivity(intent)
    }

    private fun callForegroundBackgroundActivity() {
        val intent = Intent(context, ForegroundBackgroundActivity::class.java)
        startActivity(intent)
    }

    private fun callDragAndSwipeActivity() {
        val intent = Intent(context,DragAndSwipeActivity::class.java)
        startActivity(intent)
    }

    private fun callRecyclerViewAnimActivity() {
        val intent = Intent(context,RecyclerViewAnimActivity::class.java)
        startActivity(intent)
    }

    private fun callToolbarScrollActivity() {
        val intent = Intent(context,ToolbarScrollActivity::class.java)
        startActivity(intent)
    }

    private fun callOnClickListenerActivity() {
        val intent = Intent(context,OnClickListenerActivity::class.java)
        startActivity(intent)
    }

    private fun callPageViewActivity() {
        val intent = Intent(context,PageViewActivity::class.java)
        startActivity(intent)
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