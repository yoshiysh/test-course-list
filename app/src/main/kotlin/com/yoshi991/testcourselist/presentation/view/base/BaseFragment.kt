package com.yoshi991.testcourselist.presentation.view.base

import com.yoshi991.testcourselist.presentation.view.base.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}
