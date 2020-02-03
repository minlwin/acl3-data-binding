package com.jdc.products.model.service

import android.content.Context
import androidx.room.Transaction
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Product
import com.jdc.products.model.db.repo.ProductRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService private constructor(private val dao: ProductRepo) {

    @Transaction
    suspend fun save(product: Product) = withContext(Dispatchers.IO) {
        if (product.id == 0) dao.create(product).toInt() else dao.update(product).let { product.id }
    }

    @Transaction
    suspend fun search(category:String? = null) = withContext(Dispatchers.IO) {
        category?.let { dao.findByCategory(it) } ?: dao.findAll()
    }

    fun findById(id:Int) = dao.findById(id)

    companion object {
        private lateinit var instance: ProductService

        fun getInstance(context: Context) = if (::instance.isInitialized) instance else
            ProductService(ProductDatabase.getDatabase(context).productRepo()).also {
                instance = it
            }
    }
}