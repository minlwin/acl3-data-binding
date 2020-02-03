package com.jdc.products.adapters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jdc.products.R
import com.jdc.products.databinding.ItemProductBinding
import com.jdc.products.model.db.entity.ProductWithCategory
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter:ListAdapter<ProductWithCategory, ProductAdapter.VH>(
    object : DiffUtil.ItemCallback<ProductWithCategory>() {
        override fun areItemsTheSame(
            oldItem: ProductWithCategory,
            newItem: ProductWithCategory
        ) = oldItem.product.id == newItem.product.id

        override fun areContentsTheSame(
            oldItem: ProductWithCategory,
            newItem: ProductWithCategory
        ) = oldItem == newItem
    }
) {

    class VH(val binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val dto = getItem(position)
        holder.binding.dto = dto

        holder.itemView.categoryTitle.setOnClickListener {
            it.findNavController().navigate(R.id.action_products_edit, Bundle().also { b ->
                b.putInt("id", dto.product.id)
            })
        }
    }
}