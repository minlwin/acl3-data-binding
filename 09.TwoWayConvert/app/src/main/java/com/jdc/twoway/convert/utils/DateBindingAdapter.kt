package com.jdc.twoway.convert.utils

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import java.util.*

object DateBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:date")
    fun setDateToView(editText: EditText, date:Date?) {
        date?.also {
            editText.setText(DateFormat.format.format(it))
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "app:date")
    fun getDateFromView(editText: EditText):Date? {

        val string = editText.text.toString()

        if(string.isNotEmpty()) {
            return DateFormat.format.parse(string)
        }

        return null
    }

    @JvmStatic
    @BindingAdapter("app:dateAttrChanged")
    fun setInverseListener(editText: EditText,
                           listener: InverseBindingListener) {
        editText.doAfterTextChanged {
            listener.onChange()
        }
    }
}