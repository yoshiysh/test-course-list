package com.yoshi991.testcourselist.domain.usecase

import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import com.yoshi991.testcourselist.util.extension.result
import javax.inject.Inject

interface CourseUseCase {
    suspend fun getCourses(): Result<List<Course>>
    suspend fun getUsage(id: String): Result<Usage>
}

class CourseUseCaseImpl @Inject constructor(private val courseRepository: CourseRepository) :
    CourseUseCase {

    override suspend fun getCourses(): Result<List<Course>> {
        return result { courseRepository.fetchCourses() }
    }

    override suspend fun getUsage(id: String): Result<Usage> {
        return result { courseRepository.fetchUsage(id) }
    }
}
