package com.jdc.products.model.db.repo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jdc.products.model.db.entity.Product

@Dao
interface ProductRepo {

    @Query("select * from Product where category = :name")
    fun findByCategory(name:String?):LiveData<List<Product>>

    @Insert
    fun create(p:Product)

    @Insert
    fun update(p:Product)

    @Delete
    fun delete(p:Product)
}