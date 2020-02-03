package com.jdc.products.model.db.repo

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jdc.products.model.db.entity.Product
import com.jdc.products.model.db.entity.ProductWithCategory

@Dao
interface ProductRepo {

    @Query("select * from Product where category = :name")
    fun findByCategory(name:String):LiveData<List<ProductWithCategory>>

    @Query("select * from Product")
    fun findAll():LiveData<List<ProductWithCategory>>

    @Query("select * from Product where id = :id")
    fun findById(id:Int):LiveData<Product>

    @Insert
    fun create(p:Product):Long

    @Update
    fun update(p:Product)

    @Delete
    fun delete(p:Product)
}