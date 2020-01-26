package com.jdc.twoway.adapter

import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import java.text.SimpleDateFormat
import java.util.*

object DateAdapter {

    val dateFormat = SimpleDateFormat("yyyy/MM/dd")

    @JvmStatic
    @BindingAdapter("android:date")
    fun dateToString(view:EditText, date: Date?) = date?.let {
        view.setText(dateFormat.format(it))
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:date")
    fun stringToDate(view: EditText):Date? = view.text.let {
        if(it.toString().isNotEmpty()) dateFormat.parse(it.toString()) else null
    }

    @JvmStatic
    @BindingAdapter("android:dateAttrChanged")
    fun setDateAttrChangedListener(view: EditText,
                                   attrChange: InverseBindingListener) {
        view.doAfterTextChanged {
            attrChange.onChange()
        }
    }
    
    @JvmStatic
    @BindingAdapter("android:dateLabel")
    fun dateToString(view:TextView, date: Date?) = date?.let {
        view.text = dateFormat.format(it)
    }

}