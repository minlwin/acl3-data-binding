package com.jdc.products.model.view

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jdc.products.model.service.ProductService

class ProductEditViewModel(application: Application) : AndroidViewModel(application) {

    private val service = ProductService.getInstance(application)

    val category = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val brand = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun save(view:View) {

    }
}