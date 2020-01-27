package com.jdc.products.utils

import android.os.Build
import com.jdc.products.MainActivity
import com.jdc.products.R

inline fun resourceColor(id:Int, type: () -> String):Int {

    val resources = MainActivity.resources
    val colorIdString = "${type()}$id"
    return resources.getIdentifier(colorIdString, "color", resources.getResourcePackageName(R.id.fragment))
        .let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                resources.getColor(it, null)
            } else {
                resources.getColor(it)
            }
        }
}