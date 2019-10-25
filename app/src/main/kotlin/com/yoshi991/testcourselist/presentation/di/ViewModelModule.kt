package com.yoshi991.testcourselist.presentation.di

import androidx.lifecycle.ViewModel
import com.yoshi991.testcourselist.presentation.view.base.viewmodel.ViewModelKey
import com.yoshi991.testcourselist.presentation.view.courses.CoursesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoursesViewModel::class)
    fun bindCoursesViewModel(viewModel: CoursesViewModel): ViewModel
}
