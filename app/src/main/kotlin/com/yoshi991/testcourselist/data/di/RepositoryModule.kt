package com.yoshi991.testcourselist.data.di

import com.yoshi991.testcourselist.data.repository.CourseRepositoryImpl
import com.yoshi991.testcourselist.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindCourseRepository(repository: CourseRepositoryImpl): CourseRepository
}
