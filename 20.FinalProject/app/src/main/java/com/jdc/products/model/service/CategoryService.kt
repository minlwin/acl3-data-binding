package com.jdc.products.model.service

import android.content.Context
import androidx.room.Transaction
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.db.repo.CategoryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryService private constructor(private val repo: CategoryRepo) {

    @Transaction
    suspend fun save(name: String?, c: Category) {
        withContext(Dispatchers.IO) {

            name?.also {
                repo.findById(it)?.also { oldData ->
                    repo.delete(oldData)
                }
            }

            repo.create(c)
        }
    }

    fun findAll() = repo.findAll()

    suspend fun findById(id: String) = withContext(Dispatchers.IO) {
        repo.findById(id)
    }

    companion object {

        private lateinit var instance: CategoryService

        fun getInstance(context: Context) = if (::instance.isInitialized) instance
        else CategoryService(ProductDatabase.getDatabase(context).categoryRepo()).also {
            instance = it
        }
    }
}