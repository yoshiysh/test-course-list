package com.yoshi991.testcourselist.presentation.di

import com.yoshi991.testcourselist.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            ViewModelModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
