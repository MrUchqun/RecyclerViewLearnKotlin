package com.example.recyclerviewlearn.helper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SimpleTouchHelperCallback( private val mAdapter: ItemTouchHelperAdapter ) : ItemTouchHelper.Callback() {

    override fun isLongPressDragEnabled(): Boolean { return true }

    override fun isItemViewSwipeEnabled(): Boolean { return true }

    override fun getMovementFlags( recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder ): Int {
        val dragFlags: Int = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags: Int = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove( recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder ): Boolean {
        mAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        mAdapter.onItemDismiss(viewHolder.adapterPosition)
    }
}