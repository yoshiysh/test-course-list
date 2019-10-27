package com.yoshi991.testcourselist.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yoshi991.testcourselist.data.entity.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(course: Course)

    @Query("SELECT * FROM courses")
    suspend fun getAll(): List<Course>

    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun findById(id: String): Course

    @Query("DELETE FROM courses")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM courses")
    suspend fun count(): Int
}
