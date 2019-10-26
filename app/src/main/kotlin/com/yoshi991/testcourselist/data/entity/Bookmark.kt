package com.yoshi991.testcourselist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class Bookmark(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "is_bookmark")
    val isBookmark: Boolean
)
