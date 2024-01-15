package com.kingtech.onlinesheba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.onlinesheba.R
import com.kingtech.onlinesheba.databinding.CategoryItemBinding
import com.kingtech.onlinesheba.model.Category

class CategoryAdapter(private val categoryList : List<Category>, private val context: Context):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

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
                1 -> view.findNavController().navigate(R.id.action_homeFragment_to_ambulanceFragment)
                2 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                3 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                4 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                5 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                6 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                7 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                8 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                9 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
                10 -> view.findNavController().navigate(R.id.action_homeFragment_to_fairFragment)
            }

        }
    }
}