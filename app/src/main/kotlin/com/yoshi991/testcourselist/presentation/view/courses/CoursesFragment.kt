package com.yoshi991.testcourselist.presentation.view.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.yoshi991.testcourselist.databinding.FragmentCoursesBinding
import com.yoshi991.testcourselist.presentation.view.base.BaseFragment
import com.yoshi991.testcourselist.util.SpacerItemDecoration
import com.yoshi991.testcourselist.util.extension.dp

class CoursesFragment : BaseFragment() {

    lateinit var binding: FragmentCoursesBinding

    private val viewModel: CoursesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(CoursesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoursesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GroupAdapter<ViewHolder>()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            SpacerItemDecoration(
                marginTop = 4.dp,
                marginLeft = 8.dp,
                marginRight = 8.dp,
                marginBottom = 4.dp
            )
        )

        with(viewModel) {
            courses.observe(viewLifecycleOwner) { courses ->
                binding.swipeRefresh.isRefreshing = false

                adapter.update(courses.map {
                    CourseItem(it) {
                        // TODO: on click event
                    }
                })
            }

            error.observe(viewLifecycleOwner) {
                binding.swipeRefresh.isRefreshing = false
            }
        }

        viewModel.getCourses()
        binding.swipeRefresh.isRefreshing = true
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getCourses()
        }
    }
}
