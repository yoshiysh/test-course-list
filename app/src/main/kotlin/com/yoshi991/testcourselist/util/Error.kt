package com.yoshi991.testcourselist.util

import androidx.annotation.StringRes
import com.yoshi991.testcourselist.R
import retrofit2.HttpException
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_NOT_FOUND

sealed class Error(@StringRes val resId: Int, cause: Throwable? = null) : Throwable(cause) {
    object HttpNotFound : Error(R.string.error_http_not_found)
    object HttpInternalError : Error(R.string.error_http_internal_error)
    class Unhandled(cause: Throwable?) : Error(R.string.error_unhandled, cause)

    companion object {
        fun of(throwable: Throwable): Error {
            return when (throwable) {
                is HttpException -> when (throwable.response()?.code() ?: 0) {
                    HTTP_NOT_FOUND -> HttpNotFound
                    HTTP_INTERNAL_ERROR -> HttpInternalError
                    else -> Unhandled(throwable)
                }
                else -> Unhandled(throwable)
            }
        }
    }
}
