package com.yoshi991.testcourselist.domain.usecase

import android.accounts.NetworkErrorException
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import com.yoshi991.testcourselist.util.extension.result
import java.net.UnknownHostException
import javax.inject.Inject

interface CourseUseCase {
    suspend fun getCourses(): Result<List<Course>>
    suspend fun updateBookmark(course: Course): Result<Unit>
}

class CourseUseCaseImpl @Inject constructor(private val courseRepository: CourseRepository) :
    CourseUseCase {

    override suspend fun getCourses(): Result<List<Course>> {
        return result {
            try {
                fetchCourses()
            } catch (exception: Exception) {
                when (exception) {
                    is UnknownHostException, is NetworkErrorException -> getCoursesByStorage()
                    else -> throw exception
                }
            }
        }
    }

    private suspend fun fetchCourses(): List<Course> {
        return courseRepository.fetchCourses().map { course ->
            course.apply {
                usage = getUsage(id).getOrNull()
                isBookmark = getIsBookmark(id).getOrDefault(false)
            }.also { updateCourses(it) }
        }
    }

    private suspend fun getCoursesByStorage(): List<Course> {
        return courseRepository.getCourses().map { course ->
            course.apply { isBookmark = getIsBookmark(id).getOrDefault(false) }
        }
    }

    private suspend fun updateCourses(course: Course) {
        courseRepository.updateCourse(course)
    }

    private suspend fun getUsage(id: String): Result<Usage> {
        return result { courseRepository.fetchUsage(id) }
    }

    private suspend fun getIsBookmark(id: String): Result<Boolean> {
        return result { courseRepository.getBookmark(id).isBookmark }
    }

    override suspend fun updateBookmark(course: Course): Result<Unit> {
        return if (course.isBookmark) {
            addBookmark(course.id)
        } else {
            deleteBookmark(course.id)
        }
    }

    private suspend fun addBookmark(id: String): Result<Unit> {
        return result { courseRepository.updateBookmark(id, true) }
    }

    private suspend fun deleteBookmark(id: String): Result<Unit> {
        return result { courseRepository.deleteBookmark(id) }
    }
}
