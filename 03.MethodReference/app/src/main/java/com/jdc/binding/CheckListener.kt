package com.jdc.binding

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import com.jdc.binding.databinding.ActivityMainBinding

class CheckListener(private val binding: ActivityMainBinding):BaseObservable() {

    var message = "Not Selected"

    fun isCheck(state:Boolean) {
        message = if(state) "Selected" else "Not Selected"
        binding.checkListener = this
    }
}