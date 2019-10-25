package com.yoshi991.testcourselist.data.repository

import com.yoshi991.testcourselist.data.api.API
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(private val api: API) : CourseRepository {

    override suspend fun fetchCourses(): List<Course> {
        return api.fetchCourses()
    }

    override suspend fun fetchUsage(id: Int): Usage {
        return api.fetchUsage(id)
    }
}
