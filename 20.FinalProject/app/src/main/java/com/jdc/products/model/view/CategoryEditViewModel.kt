package com.jdc.products.model.view

import android.annotation.SuppressLint
import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.products.R
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.service.CategoryService
import com.jdc.products.utils.noZero
import com.jdc.products.utils.resourceColor
import com.jdc.products.utils.validValue
import kotlinx.coroutines.launch

class CategoryEditViewModel(application: Application) : AndroidViewModel(application) {

    val name = MutableLiveData<String>("")
    private val context = application.applicationContext

    @SuppressLint("DefaultLocale")
    val sampleTitle = Transformations.map(name) {
        if (null == it || it.length <= 2) application.resources.getString(R.string.ca) else it.substring(
            0,
            2
        ).capitalize()
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

    fun save(view: View) {
        viewModelScope.launch {
            try {
                val category = Category(
                    name.validValue { "Enter Category Name." },
                    colorId.noZero { "Please Select Color" }
                )
                service.save(oldCategory, category)

                oldCategory = null
                view.findNavController().navigate(R.id.action_save_category)
            } catch (e: Throwable) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private var oldCategory: String? = null

    fun load(categoryName: String) {

        oldCategory = categoryName

        viewModelScope.launch {
            val c = service.findById(categoryName)
            name.value = c?.name
            color.value = c?.color
        }

    }
}