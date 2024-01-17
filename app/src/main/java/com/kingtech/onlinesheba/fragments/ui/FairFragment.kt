package com.kingtech.onlinesheba.fragments.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kingtech.onlinesheba.adapter.FairAdapter
import com.kingtech.onlinesheba.model.data.CategoryData

import com.kingtech.onlinesheba.databinding.FragmentFairBinding
import com.kingtech.onlinesheba.fragments.BaseFragment

class FairFragment : BaseFragment<FragmentFairBinding>(FragmentFairBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setDate()


    }

    private fun setDate() {
        val manager = GridLayoutManager(requireContext(), 1)
        binding.rcvFair.layoutManager = manager
        binding.rcvFair.adapter = FairAdapter(CategoryData.fairData,requireContext())
    }


}