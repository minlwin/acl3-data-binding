package com.jdc.products.model.db.entity

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey
    var name:String,
    var color:Int
) {
    val title:String
        @SuppressLint("DefaultLocale")
        get() = name.substring(0, 2).toUpperCase()
}