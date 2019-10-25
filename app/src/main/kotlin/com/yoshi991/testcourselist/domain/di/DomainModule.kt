package com.yoshi991.testcourselist.domain.di

import com.yoshi991.testcourselist.domain.usecase.CourseUseCase
import com.yoshi991.testcourselist.domain.usecase.CourseUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DomainModule {

    @Binds
    @Singleton
    fun bindCourseUseCase(useCase: CourseUseCaseImpl): CourseUseCase
}
