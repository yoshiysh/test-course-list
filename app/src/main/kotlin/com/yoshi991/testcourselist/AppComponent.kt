package com.yoshi991.testcourselist

import android.app.Application
import com.yoshi991.testcourselist.data.di.ApiModule
import com.yoshi991.testcourselist.data.di.RepositoryModule
import com.yoshi991.testcourselist.domain.di.DomainModule
import com.yoshi991.testcourselist.presentation.di.ActivityModule
import com.yoshi991.testcourselist.presentation.di.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ApiModule::class,
        RepositoryModule::class,
        DomainModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
