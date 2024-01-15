package com.kingtech.onlinesheba.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.kingtech.onlinesheba.adapter.AmbulanceAdapter
import com.kingtech.onlinesheba.data.CategoryData.ambulanceData

import com.kingtech.onlinesheba.databinding.FragmentAmbulanceBinding


class AmbulanceFragment : BaseFragment<FragmentAmbulanceBinding>(FragmentAmbulanceBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDate()
    }

    private fun setDate() {
        val manager = GridLayoutManager(requireContext(), 1)
        binding.rcvAmbulance.layoutManager = manager
        binding.rcvAmbulance.adapter = AmbulanceAdapter(ambulanceData,requireContext())
    }

}