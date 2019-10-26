package com.yoshi991.testcourselist.domain.repository

import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage

interface CourseRepository {
    suspend fun fetchCourses(): List<Course>
    suspend fun fetchUsage(id: String): Usage
}
