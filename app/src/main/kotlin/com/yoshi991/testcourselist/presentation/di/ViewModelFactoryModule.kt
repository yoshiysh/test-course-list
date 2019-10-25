package com.yoshi991.testcourselist.presentation.di

import androidx.lifecycle.ViewModelProvider
import com.yoshi991.testcourselist.presentation.view.base.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
