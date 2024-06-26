package com.kingtech.onlinesheba.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.onlinesheba.R
import com.kingtech.onlinesheba.databinding.CategoryItemBinding
import com.kingtech.onlinesheba.model.Category

class CategoryAdapter(private val categoryList: List<Category>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
       return CategoryViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
     return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

     val category = categoryList[position]
        holder.binding.textView.text=category.tilte
        holder.binding.imageView.setImageResource(category.image.toInt())

        holder.itemView.setOnClickListener { view ->

            when (position) {
                0 -> view.findNavController().navigate(R.id.action_homeFragment_to_newsFragment)
                1 -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putInt("itemId",position)
                    }
                )
                2 -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putInt("itemId",position)
                    }
                )
                3 -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putInt("itemId",position)
                    }
                )
                4 -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putInt("itemId",position)
                    }
                )
                5 -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,
                    Bundle().apply {
                        putInt("itemId",position)
                    }
                )
                6 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                7 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                8 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                9 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                10 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
            }

        }
    }
}