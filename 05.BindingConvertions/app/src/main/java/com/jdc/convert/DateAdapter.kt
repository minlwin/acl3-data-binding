package com.jdc.convert

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

object DateAdapter {

    private val format = SimpleDateFormat("yyyy/MM/dd")

    @JvmStatic
    @BindingAdapter("app:date")
    fun dateToString(textView: TextView, date: Date) {
        textView.text = format.format(date)
    }
}