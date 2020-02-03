package com.jdc.products.model.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithCategory(
    @Embedded
    val product: Product,
    @Relation(
        entity = Category::class,
        parentColumn = "category",
        entityColumn = "name"
    )
    val category: Category
)