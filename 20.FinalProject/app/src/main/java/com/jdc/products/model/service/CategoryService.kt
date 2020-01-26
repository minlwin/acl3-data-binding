package com.jdc.products.model.service

import androidx.room.Transaction
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.db.repo.CategoryRepo

class CategoryService(private val repo:CategoryRepo) {

    @Transaction
    suspend fun create(vararg list:Category) {
        for(c in list) {
            repo.create(c)
        }
    }

    @Transaction
    suspend fun update(name:String, c:Category) {
        val oldData = repo.findById(name).value
        if(null != oldData) {
            repo.delete(oldData)
        }

        repo.create(c)
    }

    suspend fun findAll() = repo.findAll()
}