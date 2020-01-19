package com.jdc.custom

import android.widget.TextView
import androidx.databinding.BindingAdapter

object IntegerBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:intValue")
    fun setInt(view:TextView, data:Int) {
        view.text = data.toString()
    }
}