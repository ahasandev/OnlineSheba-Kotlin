package com.kingtech.onlinesheba.fragments.ui


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kingtech.onlinesheba.adapter.NewsAdapter
import com.kingtech.onlinesheba.model.data.CategoryData.newsData
import com.kingtech.onlinesheba.databinding.FragmentNewsBinding
import com.kingtech.onlinesheba.fragments.BaseFragment


class NewsFragment : BaseFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

    }

    private fun setAdapter() {
        val manager = GridLayoutManager(requireContext(), 1)
        binding.rcvNewsItem.layoutManager = manager
        binding.rcvNewsItem.adapter = NewsAdapter(newsData)

    }

}