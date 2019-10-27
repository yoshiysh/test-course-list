package com.yoshi991.testcourselist.presentation.view.courses

import androidx.lifecycle.LiveData
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.domain.usecase.CourseUseCase
import com.yoshi991.testcourselist.presentation.view.base.BaseViewModel
import com.yoshi991.testcourselist.util.extension.mutableLiveDataOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoursesViewModel @Inject constructor(private val courseUseCase: CourseUseCase) :
    BaseViewModel() {

    private val _courses = mutableLiveDataOf<List<Course>>()
    val courses: LiveData<List<Course>> get() = _courses

    fun getCourses(shouldRefresh: Boolean = false) {
        if (!shouldRefresh && _courses.value?.isNotEmpty() == true) return

        coroutineScope.launch {
            courseUseCase.getCourses()
                .onSuccess { _courses.postValue(it) }
                .onFailure { onError(it) }
        }
    }

    fun updateBookmark(course: Course) {
        coroutineScope.launch {
            courseUseCase.updateBookmark(course)
        }
    }
}
