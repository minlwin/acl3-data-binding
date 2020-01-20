package com.jdc.convert

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

object DateConversion {

    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm")

    @JvmStatic
    @BindingConversion
    fun convertToString(date: Date) = format.format(date)
}