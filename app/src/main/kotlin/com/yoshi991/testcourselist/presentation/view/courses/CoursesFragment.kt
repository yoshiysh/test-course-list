package com.yoshi991.testcourselist.presentation.view.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yoshi991.testcourselist.databinding.FragmentCoursesBinding
import com.yoshi991.testcourselist.presentation.view.base.BaseFragment

class CoursesFragment : BaseFragment() {

    lateinit var binding: FragmentCoursesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoursesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}
