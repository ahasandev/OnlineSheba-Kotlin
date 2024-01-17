package com.kingtech.onlinesheba.fragments.ui


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.kingtech.onlinesheba.adapter.DetailsAdapter
import com.kingtech.onlinesheba.model.data.CategoryData
import com.kingtech.onlinesheba.databinding.FragmentDetailsBinding
import com.kingtech.onlinesheba.fragments.BaseFragment


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val position = requireArguments().getInt("itemId")

        binding.rcvDetails.layoutManager = LinearLayoutManager(requireContext())

        when(position){
            3 -> binding.rcvDetails.adapter = DetailsAdapter(CategoryData.helplineData,requireContext())
            4 -> binding.rcvDetails.adapter = DetailsAdapter(CategoryData.thanaData,requireContext())
            5 -> binding.rcvDetails.adapter = DetailsAdapter(CategoryData.lowerData,requireContext())
        }






    }

}