package com.yoshi991.testcourselist.presentation.view.courses

import com.xwray.groupie.databinding.BindableItem
import com.yoshi991.testcourselist.R
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.databinding.ItemCourseBinding

data class CourseItem(
    private val course: Course,
    private val onClick: (Course) -> Unit
) : BindableItem<ItemCourseBinding>() {

    override fun getLayout(): Int = R.layout.item_course

    override fun bind(viewBinding: ItemCourseBinding, position: Int) {
        viewBinding.course = course
        viewBinding.itemTopics.text = "%,d".format(course.numberOfTopics)
        viewBinding.itemStatus.setText(
            course.usage?.let { return@let it.status.resId } ?: R.string.usage_status_not_started
        )
        updateBookmarkImage(viewBinding)
        viewBinding.root.setOnClickListener {
            course.isBookmark = !course.isBookmark
            updateBookmarkImage(viewBinding)
            onClick(course)
        }
    }

    private fun updateBookmarkImage(viewBinding: ItemCourseBinding) {
        val resId = if (course.isBookmark) R.drawable.ic_bookmark_on else R.drawable.ic_bookmark_off
        viewBinding.itemBookmark.setImageResource(resId)
    }
}
