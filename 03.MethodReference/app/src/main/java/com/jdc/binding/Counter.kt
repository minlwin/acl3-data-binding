package com.jdc.binding

import android.content.Context
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.Observable.OnPropertyChangedCallback
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class Counter(private val contextSupplier:() -> Context) {

    val count = ObservableInt(-1)

    val message = ObservableField<String>("Message")

    init {

        count.addOnPropertyChangedCallback(object : OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                message.set("Count is ${count.get()}")
            }
        })

        count.set(0)
    }

    fun countUp() {
        count.set(count.get() + 1)
        Toast.makeText(contextSupplier(), "Count is ${count.get()}",
            Toast.LENGTH_SHORT).show()
    }
}