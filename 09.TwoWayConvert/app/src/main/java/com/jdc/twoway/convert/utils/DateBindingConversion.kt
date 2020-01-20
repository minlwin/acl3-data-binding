package com.jdc.twoway.convert.utils

import androidx.databinding.BindingConversion
import java.util.*

object DateBindingConversion {

    @JvmStatic
    @BindingConversion
    fun dateToString(date: Date?) = date?.let {
        DateFormat.format.format(it)
    }

}