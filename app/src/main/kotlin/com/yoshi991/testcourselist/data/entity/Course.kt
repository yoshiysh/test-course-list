package com.yoshi991.testcourselist.data.entity

data class Course(
    val id: String,
    val name: String,
    val teacherName: String,
    val numberOfTopics: Int,
    val iconUrl: String
) {
    var usage: Usage? = null
}
