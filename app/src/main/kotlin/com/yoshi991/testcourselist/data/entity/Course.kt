package com.yoshi991.testcourselist.data.entity

import androidx.room.*

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey
    val id: String,
    val name: String,
    @ColumnInfo(name = "teacher_name")
    val teacherName: String,
    @ColumnInfo(name = "number_of_topics")
    val numberOfTopics: Int,
    @ColumnInfo(name = "icon_url")
    val iconUrl: String
) {
    @Embedded
    var usage: Usage? = null
    @Ignore
    var isBookmark: Boolean = false
}
