package com.jdc.twoway.convert.utils

import androidx.databinding.InverseMethod
import java.util.*

object DateBindingConverter {

    @JvmStatic
    @InverseMethod("stringToDate")
    fun dateToString(date: Date?) = date?.let {
        DateFormat.format.format(it)
    }

    @JvmStatic
    fun stringToDate(string: String?) = string?.let {
        DateFormat.format.parse(it)
    }
}