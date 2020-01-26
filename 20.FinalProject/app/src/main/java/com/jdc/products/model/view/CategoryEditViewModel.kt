package com.jdc.products.model.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.service.CategoryService
import kotlinx.coroutines.launch

class CategoryEditViewModel(application: Application) : AndroidViewModel(application) {

    val name = MutableLiveData<String>()
    val color = MutableLiveData<Int>()

    private var service:CategoryService  =CategoryService(ProductDatabase.getDatabase(application).categoryRepo())

    fun save() {
        viewModelScope.launch {
            name.value?.also {
                color.value?.also { c ->
                     service.create(Category(it, c))
                }
            }
        }
    }
}