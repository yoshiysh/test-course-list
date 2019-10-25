package com.yoshi991.testcourselist.util.extension

suspend fun <T> result(block: suspend () -> T): Result<T> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}
