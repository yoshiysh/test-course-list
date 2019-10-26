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

    override suspend fun updateCourses(courses: List<Course>) {
        courses.map { courseDao.upsert(it) }
    }

    override suspend fun getCourses(): List<Course> {
        return courseDao.getAll()
    }

    override suspend fun fetchUsage(id: String): Usage {
        return api.fetchUsage(id)
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
