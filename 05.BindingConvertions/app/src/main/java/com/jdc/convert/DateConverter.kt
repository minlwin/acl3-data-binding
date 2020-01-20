package com.jdc.convert

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    private val format = SimpleDateFormat("yyyy/MM/dd")

    @JvmStatic
    fun dateToString(date:Date):String {
        return format.format(date)
    }
}