package com.yoshi991.testcourselist.domain.usecase

import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import com.yoshi991.testcourselist.util.extension.result
import javax.inject.Inject

interface CourseUseCase {
    suspend fun fetchCourses(): Result<List<Course>>
    suspend fun fetchUsage(id: Int): Result<Usage>
}

class CourseUseCaseImpl @Inject constructor(private val courseRepository: CourseRepository) :
    CourseUseCase {

    override suspend fun fetchCourses(): Result<List<Course>> {
        return result { courseRepository.fetchCourses() }
    }

    override suspend fun fetchUsage(id: Int): Result<Usage> {
        return result { courseRepository.fetchUsage(id) }
    }
}
