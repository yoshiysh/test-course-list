package com.yoshi991.testcourselist.data.api

import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("/api/courses")
    suspend fun fetchCourses(): List<Course>

    @GET("/api/{course_id}/usage")
    suspend fun fetchUsage(@Path("course_id") course_id: Int): Usage
}
