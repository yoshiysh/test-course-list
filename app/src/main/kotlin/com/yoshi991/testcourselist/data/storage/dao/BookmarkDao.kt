package com.yoshi991.testcourselist.data.storage.dao

import androidx.room.*
import com.yoshi991.testcourselist.data.entity.Bookmark

@Dao
interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: Bookmark)

    @Query("SELECT * FROM bookmarks WHERE id = :id")
    suspend fun find(id: String): Bookmark

    @Query("DELETE FROM bookmarks WHERE id = :id")
    suspend fun delete(id: String)
}
