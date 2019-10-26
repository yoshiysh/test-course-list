package com.yoshi991.testcourselist.data.di

import android.content.Context
import androidx.room.Room
import com.yoshi991.testcourselist.data.storage.dao.BookmarkDao
import com.yoshi991.testcourselist.data.storage.database.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, Database.DB_NAME)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()
    }

    @Singleton
    @Provides
    fun provide(db: Database): BookmarkDao {
        return db.bookmarkDao()
    }
}
