package com.jdc.products.model.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    var id:Int,
    var name:String,
    @ForeignKey(
        entity = Category::class,
        parentColumns = ["name"],
        childColumns = ["category"],
        onDelete = ForeignKey.SET_NULL,
        onUpdate = ForeignKey.CASCADE
    )
    var category: String?,
    var price:Int,
    var brand:String,
    var description:String
)