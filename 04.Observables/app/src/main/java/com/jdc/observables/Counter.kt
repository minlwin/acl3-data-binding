package com.jdc.observables

import androidx.databinding.ObservableInt

class Counter {

    var count = ObservableInt(0)

    fun countUp() {
        count.set(count.get() + 1)
    }
}