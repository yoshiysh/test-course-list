package com.yoshi991.testcourselist.util

import okhttp3.OkHttpClient

interface OkHttpClientProvider {
    val okHttpClient: OkHttpClient
}
