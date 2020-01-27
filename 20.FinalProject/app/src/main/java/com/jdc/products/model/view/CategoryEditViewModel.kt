package com.jdc.products.model.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.jdc.products.R
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.service.CategoryService
import com.jdc.products.utils.resourceColor
import kotlinx.coroutines.launch

class CategoryEditViewModel(application: Application) : AndroidViewModel(application) {

    val name = MutableLiveData<String>("")

    val sampleTitle = Transformations.map(name) {
        if (null == it || it.length <= 2) "CA" else it.substring(0, 2).toUpperCase()
    }

    val sampleName = Transformations.map(name) {
        if (null == it || it.isEmpty()) "Category" else it
    }

    val color = MutableLiveData<Int>(R.id.rd1)

    private val colorId = Transformations.map(color) {
        when (it) {
            R.id.rd1 -> 1
            R.id.rd2 -> 2
            R.id.rd3 -> 3
            R.id.rd4 -> 4
            R.id.rd5 -> 5
            else -> 6
        }
    }

    val backColor = Transformations.map(colorId) {
        resourceColor(it) { "color" }
    }

    val textColor = Transformations.map(colorId) {
        resourceColor(it) { "text" }
    }

    private var service: CategoryService =
        CategoryService(ProductDatabase.getDatabase(application).categoryRepo())

    fun save() {

        viewModelScope.launch {
            name.value?.also {
                colorId.value?.also { c ->
                    service.create(Category(it, c))
                }
            }
        }
    }
}