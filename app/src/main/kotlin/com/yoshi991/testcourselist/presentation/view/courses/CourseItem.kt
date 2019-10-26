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
        viewBinding.root.setOnClickListener { onClick(course) }
    }
}
