package com.jdc.share.component

import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textview.MaterialTextView
import java.util.*

object DateAdapter {

    @JvmStatic
    @BindingAdapter("app:date")
    fun setDate(editText: EditText, date: MutableLiveData<Date?>) = date.value?.let {
        editText.setText(dateFormat.format(it))
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "app:date")
    fun getDate(editText: EditText) = editText.text.toString().let {
        if(it.isNotEmpty()) dateFormat.parse(it) else null
    }

    @JvmStatic
    @BindingAdapter("app:dateAttrChanged")
    fun setListener(editText: EditText, listener:InverseBindingListener) =
        editText.doAfterTextChanged {
            listener.onChange()
        }

}