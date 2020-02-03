package com.jdc.products.utils

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jdc.products.MainActivity
import com.jdc.products.R

inline fun resourceColor(id: Int, type: () -> String): Int {

    val resources = MainActivity.resources
    val colorIdString = "${type()}$id"
    return resources.getIdentifier(
        colorIdString,
        "color",
        resources.getResourcePackageName(R.id.fragment)
    )
        .let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                resources.getColor(it, null)
            } else {
                resources.getColor(it)
            }
        }
}

inline fun LiveData<String>.validValue(message: () -> String): String {

    if (this.value.isNullOrBlank()) {
        throw Throwable(message())
    }
    return this.value!!
}

inline fun LiveData<Int>.noZero(message: () -> String): Int {

    if (this.value == null || this.value == 0) {
        throw Throwable(message())
    }

    return this.value!!
}