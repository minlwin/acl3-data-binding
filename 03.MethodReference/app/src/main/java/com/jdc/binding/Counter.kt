package com.jdc.binding

import android.view.View
import androidx.databinding.ObservableInt

class Counter() {

    var count = ObservableInt(0)

    fun countUp(view: View) {
        count.set(count.get() + 1)
    }
}