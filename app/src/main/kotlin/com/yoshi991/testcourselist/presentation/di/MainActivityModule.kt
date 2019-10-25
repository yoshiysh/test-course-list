package com.yoshi991.testcourselist.presentation.di

import com.yoshi991.testcourselist.presentation.view.courses.CoursesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeCoursesFragment(): CoursesFragment
}
