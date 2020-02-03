package com.jdc.products.model.view

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.jdc.products.R
import com.jdc.products.model.db.entity.Product
import com.jdc.products.model.service.ProductService
import com.jdc.products.utils.noZero
import com.jdc.products.utils.validValue
import kotlinx.coroutines.launch

class ProductEditViewModel(application: Application) : AndroidViewModel(application) {

    private val service = ProductService.getInstance(application)
    private val context = application.applicationContext

    val category = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val brand = MutableLiveData<String>()
    val price = MutableLiveData<Int>()
    val description = MutableLiveData<String>()

    private var id:Int = 0

    fun save(view:View) {

        viewModelScope.launch {

            try {
                val product = Product(
                    id = id,
                    category = category.validValue { "Please Select Category" },
                    name = name.validValue { "Please Enter Product Name" },
                    brand = brand.validValue { "Please Enter Brand Name" },
                    price = price.noZero { "Please set Value for Product" },
                    description = description.validValue { "Please Enter Description" }
                )

                service.save(product)

                id = 0

                view.findNavController().navigate(R.id.action_save_product, Bundle().also {
                    it.putString("category", product.category)
                })

            } catch (e:Throwable) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setData(data:Product) {
        id = data.id
        category.value = data.category
        name.value = data.name
        brand.value = data.brand
        price.value = data.price
        description.value = data.description
    }
}