package com.yoshi991.testcourselist.domain.usecase

import com.yoshi991.testcourselist.data.entity.Bookmark
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import com.yoshi991.testcourselist.util.extension.result
import javax.inject.Inject

interface CourseUseCase {
    suspend fun getCourses(): Result<List<Course>>
    suspend fun updateBookmark(course: Course): Result<Unit>
}

class CourseUseCaseImpl @Inject constructor(private val courseRepository: CourseRepository) :
    CourseUseCase {

    override suspend fun getCourses(): Result<List<Course>> {
        return result {
            courseRepository.fetchCourses().map { course ->
                course.apply {
                    usage = getUsage(id).getOrNull()
                    isBookmark = getBookmark(id).getOrNull()?.isBookmark ?: false
                }
            }
        }
    }

    private suspend fun getUsage(id: String): Result<Usage> {
        return result { courseRepository.fetchUsage(id) }
    }

    private suspend fun getBookmark(id: String): Result<Bookmark> {
        return result { courseRepository.getBookmark(id) }
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
