package com.yoshi991.testcourselist.data.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.yoshi991.testcourselist.BuildConfig
import com.yoshi991.testcourselist.data.api.API
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkUtilModule::class])
object ApiModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(
        logInterceptor: HttpLoggingInterceptor,
        stethoInterceptor: StethoInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .apply { if (BuildConfig.DEBUG) addNetworkInterceptor(stethoInterceptor) }
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideApi(gson: Gson, httpClient: OkHttpClient): API {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
            .create(API::class.java)
    }
}
