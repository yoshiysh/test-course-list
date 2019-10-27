package com.yoshi991.testcourselist.data.repository

import com.yoshi991.testcourselist.data.api.API
import com.yoshi991.testcourselist.data.entity.Bookmark
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.data.storage.dao.BookmarkDao
import com.yoshi991.testcourselist.data.storage.dao.CourseDao
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl
@Inject
constructor(
    private val api: API,
    private val courseDao: CourseDao,
    private val bookmarkDao: BookmarkDao
) : CourseRepository {

    override suspend fun fetchCourses(): List<Course> {
        return api.fetchCourses()
    }

    override suspend fun updateCourse(course: Course) {
        courseDao.upsert(course)
    }

    override suspend fun updateCourses(courses: List<Course>) {
        courses.map { updateCourse(it) }
    }

    override suspend fun getCourses(): List<Course> {
        return courseDao.getAll()
    }

    override suspend fun getCourse(id: String): Course {
        return courseDao.findById(id)
    }

    override suspend fun deleteCourses() {
        return courseDao.deleteAll()
    }

    override suspend fun fetchUsage(id: String): Usage {
        return api.fetchUsage(id)
    }

    override suspend fun getBookmarks(): List<Bookmark> {
        return bookmarkDao.getAll()
    }

    override suspend fun getBookmark(id: String): Bookmark {
        return bookmarkDao.find(id)
    }

    override suspend fun updateBookmark(id: String, isBookmark: Boolean) {
        return bookmarkDao.upsert(Bookmark(id, isBookmark))
    }

    override suspend fun deleteBookmark(id: String) {
        return bookmarkDao.delete(id)
    }
}
