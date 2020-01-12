package com.jdc.binding

import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.databinding.BindingAdapter

class BindingUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("app:onStateChange")
        fun setOnStateChange(view: CheckBox, listener:CompoundButton.OnCheckedChangeListener) {
            view.setOnCheckedChangeListener(listener)
        }

    }

}

