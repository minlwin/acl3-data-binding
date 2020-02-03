package com.jdc.products.adapters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.products.R
import com.jdc.products.databinding.ItemCategoryBinding
import com.jdc.products.model.db.entity.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter:ListAdapter<Category, CategoryAdapter.CategoryVH>(object : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem.name == newItem.name
    override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
}) {

    class CategoryVH(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryVH(
        ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val category = getItem(position)
        holder.binding.category = category

        holder.itemView.editBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_categories_to_categoryEdit, Bundle().also {
                b -> b.putString("name", category.name)
            })
        }

        holder.itemView.icon.setOnClickListener {
            it.findNavController().navigate(R.id.action_categories_to_products, Bundle().also {
                b -> b.putString("category", category.name)
            })
        }
    }
}