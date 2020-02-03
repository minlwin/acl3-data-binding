package com.jdc.products.adapters.bind

import androidx.databinding.InverseMethod

object IntegerConverter  {

    @JvmStatic
    fun intToString(int: Int?) = int?.toString()

    @JvmStatic
    @InverseMethod("intToString")
    fun stringToInt(string: String?) = string?.let {
        if(string.isNotEmpty()) {
            return@let it.toInt()
        } else {
            return@let null
        }
    }
}