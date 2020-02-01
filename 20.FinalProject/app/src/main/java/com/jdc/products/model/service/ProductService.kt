package com.jdc.products.model.service

import android.content.Context
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.repo.ProductRepo

class ProductService private constructor(private val dao: ProductRepo) {


    companion object {
        private lateinit var instance: ProductService

        fun getInstance(context: Context) = if (::instance.isInitialized) instance else
            ProductService(ProductDatabase.getDatabase(context).productRepo()).also {
                instance = it
            }
    }
}