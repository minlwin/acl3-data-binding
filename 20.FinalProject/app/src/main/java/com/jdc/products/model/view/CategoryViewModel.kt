package com.jdc.products.model.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.service.CategoryService

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var service:CategoryService

    val list:LiveData<List<Category>> = liveData {
        service.findAll()
    }

    init {
        val db = ProductDatabase.getDatabase(application)
        service = CategoryService(db.categoryRepo())
    }
}