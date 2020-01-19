package com.jdc.custom

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    private val formatter = SimpleDateFormat("yyyy/MM/dd")

    @BindingConversion
    @JvmStatic
    fun convertToString(date:Date) = formatter.format(date)
}