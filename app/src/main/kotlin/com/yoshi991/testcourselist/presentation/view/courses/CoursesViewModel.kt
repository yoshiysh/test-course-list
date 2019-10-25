package com.yoshi991.testcourselist.presentation.view.courses

import com.yoshi991.testcourselist.domain.usecase.CourseUseCase
import com.yoshi991.testcourselist.presentation.view.base.BaseViewModel
import javax.inject.Inject

class CoursesViewModel @Inject constructor(private val courseUseCase: CourseUseCase) :
    BaseViewModel()
