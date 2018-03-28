package vn.beautylife.viewpagertransform

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView

class ReuseItemAnimator : DefaultItemAnimator() {

    override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder, payloads: MutableList<Any>): Boolean {
        return true
    }

}