package com.yoshi991.testcourselist.presentation.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoshi991.testcourselist.BuildConfig
import com.yoshi991.testcourselist.util.Error
import com.yoshi991.testcourselist.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    private val _error = SingleLiveEvent<Error>()
    val error: LiveData<Error> = _error

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e("Unhandled Exception: $throwable")
        if (BuildConfig.DEBUG) throw throwable else onError(throwable)
    }
    protected val coroutineScope by lazy { CoroutineScope(Dispatchers.IO + job + exceptionHandler) }

    open fun onError(t: Throwable) {
        _error.postValue(Error.of(t))
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
