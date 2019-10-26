package com.yoshi991.testcourselist.presentation.view.courses

import androidx.lifecycle.LiveData
import com.yoshi991.testcourselist.data.entity.Course
import com.yoshi991.testcourselist.data.entity.Usage
import com.yoshi991.testcourselist.domain.usecase.CourseUseCase
import com.yoshi991.testcourselist.presentation.view.base.BaseViewModel
import com.yoshi991.testcourselist.util.extension.mutableLiveDataOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoursesViewModel @Inject constructor(private val courseUseCase: CourseUseCase) :
    BaseViewModel() {

    private val _courses = mutableLiveDataOf<List<Course>>()
    val courses: LiveData<List<Course>> get() = _courses

    fun getCourses() {
        coroutineScope.launch {
            courseUseCase.getCourses()
                .onSuccess {
                    val course = it.map { course ->
                        val result = getUsage(course).getOrNull()
                        return@map course.apply { usage = result }
                    }
                    _courses.postValue(course)
                }
                .onFailure {
                    onError(it)
                }
        }
    }

    private suspend fun getUsage(course: Course): Result<Usage> {
        return courseUseCase.getUsage(course.id)
    }
}
