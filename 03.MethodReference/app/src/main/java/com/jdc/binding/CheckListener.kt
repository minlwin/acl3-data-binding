package com.jdc.binding

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class CheckListener():BaseObservable() {

    var message = ObservableField<String>("Not Selected")

    fun isCheck(state:Boolean) {
        message.set(if(state) "Selected" else "Not Selected")
    }
}