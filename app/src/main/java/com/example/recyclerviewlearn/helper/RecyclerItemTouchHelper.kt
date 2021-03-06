package com.example.recyclerviewlearn.helper

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlearn.adapter.ForeBackGroundAdapter

class RecyclerItemTouchHelper(

    dragDirs: Int,
    swipeDirs: Int,
    private val listener: RecyclerItemTouchHelperListener

    ): ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder): Boolean {
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (viewHolder != null && viewHolder is ForeBackGroundAdapter.ForeBackGroundHolder){
            val foreGroundView : View = viewHolder.foreGround

            getDefaultUIUtil().onSelected(foreGroundView)
        }
    }

    override fun onChildDrawOver(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder?,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (viewHolder is ForeBackGroundAdapter.ForeBackGroundHolder) {
            val foreGround: View = viewHolder.foreGround
            getDefaultUIUtil().onDrawOver(c, recyclerView, foreGround, dX/3, dY, actionState, isCurrentlyActive)
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        if (viewHolder is ForeBackGroundAdapter.ForeBackGroundHolder){
            val foreGround: View = viewHolder.foreGround
            getDefaultUIUtil().clearView(foreGround)
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (viewHolder is ForeBackGroundAdapter.ForeBackGroundHolder){
            val foreGround = viewHolder.foreGround
            getDefaultUIUtil().onDraw(c, recyclerView, foreGround,dX/3, dY, actionState, isCurrentlyActive)
        }
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder, direction, viewHolder.adapterPosition)
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

    interface RecyclerItemTouchHelperListener {
        fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int)
    }

}