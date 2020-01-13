package com.jdc.binding

import android.view.View
import com.jdc.binding.databinding.ActivityMainBinding

class Counter(private val binding: ActivityMainBinding) {

    var count:Int = 0

    fun countUp(view: View) {
        count = count + 1
        binding.counter = this
    }
}