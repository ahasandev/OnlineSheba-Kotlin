package com.kingtech.onlinesheba.fragments.ui

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.kingtech.onlinesheba.R
import com.kingtech.onlinesheba.adapter.CategoryAdapter
import com.kingtech.onlinesheba.model.data.CategoryData.categoryData
import com.kingtech.onlinesheba.databinding.FragmentHomeBinding
import com.kingtech.onlinesheba.fragments.BaseFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDate()

        setUpBottomNavigation()



        val linearLayoutManager = LinearLayoutManager(requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 3) // Specify the number of columns in the grid
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


        binding.layoutClike.setOnClickListener {
            binding.recyclerview.layoutManager = when (binding.recyclerview.layoutManager) {
                is GridLayoutManager -> staggeredGridLayoutManager
                is LinearLayoutManager -> gridLayoutManager
                is StaggeredGridLayoutManager -> linearLayoutManager
                else -> linearLayoutManager
            }

        }
        setAdapter(gridLayoutManager)

        binding.noticeText.isSelected = true

        val toggle = ActionBarDrawerToggle(activity,binding.drawerlayout, R.string.open_drawer, R.string.close_drawer)
        binding.drawerlayout.addDrawerListener(toggle)
        binding.imageMenu.setOnClickListener { binding.drawerlayout.openDrawer(GravityCompat.START) }

        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressed = OnBackPressedCallback::handleOnBackPressed)




        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mAbout ->
                    findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                R.id.mShare -> {
                    findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                }
            }
            binding.drawerlayout.closeDrawer(GravityCompat.START)

            true
        }




        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.dinajpur_5,ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.dinajpur_4,ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.dinajpur3,ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel(R.drawable.dinajpur3,ScaleTypes.CENTER_CROP))
        binding.imageSlider.setImageList(imageList)





    }

    private fun setUpBottomNavigation() {
        val bottomNavigationItems = mutableListOf(
            CurvedBottomNavigation.Model(R.id.action_homeFragment_to_detailsFragment, "Home", R.drawable.baseline_home_24),
            CurvedBottomNavigation.Model(R.id.action_homeFragment_to_ambulanceFragment, "Setting", R.drawable.baseline_local_phone_24),
            CurvedBottomNavigation.Model(R.id.action_homeFragment_to_newsFragment,"Profile", R.drawable.round_account_circle_24),

        )
        binding.bottomNavigation.apply {
            bottomNavigationItems.forEach { add(it) }
            setOnClickMenuListener {
            findNavController()
            }

        }
    }


    private fun setAdapter(manager : GridLayoutManager) {
        binding.recyclerview.layoutManager = manager
        binding.recyclerview.adapter = CategoryAdapter(categoryData)

    }


    private fun setDate() {
        val formatter = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        formatter.timeZone = TimeZone.getDefault()
        val date1 = Date()
        val date: String = formatter.format(date1)
        binding.tvDate.text= date
    }



}