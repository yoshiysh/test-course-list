package com.yoshi991.testcourselist.presentation.view.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yoshi991.testcourselist.databinding.FragmentBookmarksBinding
import com.yoshi991.testcourselist.presentation.view.base.BaseFragment

class BookmarksFragment : BaseFragment() {

    lateinit var binding: FragmentBookmarksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarksBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}