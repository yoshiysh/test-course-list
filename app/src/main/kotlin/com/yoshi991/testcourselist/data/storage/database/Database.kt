package com.yoshi991.testcourselist.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoshi991.testcourselist.data.entity.Bookmark
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.storage.dao.BookmarkDao
import com.yoshi991.testcourselist.data.storage.dao.CourseDao

@Database(entities = [Course::class, Bookmark::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        const val DB_NAME = "course.db"
    }
}
