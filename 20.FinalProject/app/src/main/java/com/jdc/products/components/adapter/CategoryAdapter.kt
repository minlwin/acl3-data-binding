package com.jdc.products.components.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.products.databinding.ItemCategoryBinding
import com.jdc.products.model.db.entity.Category

class CategoryAdapter:ListAdapter<Category, CategoryAdapter.CategoryVH>(CategoryCallBack) {

    class CategoryVH(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryVH(
        ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.binding.category = getItem(position)
    }
}