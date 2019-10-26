package com.yoshi991.testcourselist.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacerItemDecoration(
    private val marginLeft: Int? = null,
    private val marginTop: Int? = null,
    private val marginRight: Int? = null,
    private val marginBottom: Int? = null
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        marginLeft?.let { outRect.left = it }
        marginTop?.let { outRect.top = it }
        marginRight?.let { outRect.right = it }
        marginBottom?.let { outRect.bottom = it }
    }
}
