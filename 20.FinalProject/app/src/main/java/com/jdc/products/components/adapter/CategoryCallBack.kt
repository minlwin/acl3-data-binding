package com.jdc.products.components.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jdc.products.model.db.entity.Category

object CategoryCallBack: DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }
}