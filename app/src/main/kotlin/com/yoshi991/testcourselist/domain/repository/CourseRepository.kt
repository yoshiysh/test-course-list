package com.yoshi991.testcourselist.domain.repository

import com.yoshi991.testcourselist.data.entity.Bookmark
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage

interface CourseRepository {
    suspend fun fetchCourses(): List<Course>
    suspend fun updateCourses(courses: List<Course>)
    suspend fun getCourses(): List<Course>
    suspend fun fetchUsage(id: String): Usage
    suspend fun getBookmark(id: String): Bookmark
    suspend fun updateBookmark(id: String, isBookmark: Boolean)
    suspend fun deleteBookmark(id: String)
}
