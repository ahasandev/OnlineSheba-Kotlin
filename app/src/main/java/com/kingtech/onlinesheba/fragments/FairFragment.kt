package com.kingtech.onlinesheba.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.recyclerview.widget.GridLayoutManager
import com.kingtech.onlinesheba.adapter.AmbulanceAdapter
import com.kingtech.onlinesheba.adapter.FairAdapter
import com.kingtech.onlinesheba.data.CategoryData

import com.kingtech.onlinesheba.databinding.FragmentFairBinding

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