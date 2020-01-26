package com.jdc.share.component

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import java.util.*

object DateLabelAdapter {

    @JvmStatic
    @BindingAdapter("app:dateLabel")
    fun setDate(textView: TextView, data:MutableLiveData<Date?>) = data.value?.also {
        textView.text = dateFormat.format(it)
    }

}