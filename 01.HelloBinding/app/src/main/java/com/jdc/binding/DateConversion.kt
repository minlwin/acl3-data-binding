package com.jdc.binding

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

object DateConversion {

    private val format = SimpleDateFormat("yyyy-MM-dd")

    @JvmStatic
    @BindingConversion
    fun convertToString(date:Date) = format.format(date)
}