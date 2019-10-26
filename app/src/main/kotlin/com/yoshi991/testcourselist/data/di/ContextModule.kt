package com.yoshi991.testcourselist.data.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ContextModule {

    @Binds
    @Singleton
    fun bindContext(application: Application): Context
}
