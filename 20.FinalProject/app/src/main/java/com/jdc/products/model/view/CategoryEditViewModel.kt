package com.jdc.products.model.view

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.products.R
import com.jdc.products.model.db.ProductDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.service.CategoryService
import com.jdc.products.utils.resourceColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    private var service: CategoryService = CategoryService.getInstance(application)

    fun save(view:View) {

        name.value?.also {
            colorId.value?.also { c ->
                viewModelScope.launch {
                    service.save(oldCategory, Category(it, c))
                    oldCategory = null
                }

                view.findNavController().navigate(R.id.action_save_category)
            }
        }
    }

    private var oldCategory:String? = null

    fun load(categoryName:String) {

        oldCategory = categoryName

        viewModelScope.launch {
            val c = service.findById(categoryName)
            name.value = c?.name
            color.value = c?.color
        }

    }
}