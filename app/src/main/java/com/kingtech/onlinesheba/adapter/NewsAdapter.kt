package com.kingtech.onlinesheba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.onlinesheba.R
import com.kingtech.onlinesheba.databinding.CategoryItemBinding
import com.kingtech.onlinesheba.model.News

class NewsAdapter(private val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val news = newsList[position]
        holder.binding.textView.text=news.tilte
        holder.binding.imageView.setImageResource(news.image.toInt())

        holder.itemView.setOnClickListener { view ->

        view.findNavController().navigate(R.id.action_newsFragment_to_webViewFragment)

        }
    }
}