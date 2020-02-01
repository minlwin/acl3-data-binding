package com.jdc.products.model.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String,
    @ForeignKey(
        entity = Category::class,
        parentColumns = ["name"],
        childColumns = ["category"],
        onDelete = ForeignKey.CASCADE
    )
    var category: String,
    var price:Int,
    var brand:String,
    var description:String
)