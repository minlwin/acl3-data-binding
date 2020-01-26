package com.jdc.products.model.db.repo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jdc.products.model.db.entity.Category

@Dao
interface CategoryRepo {

    @Query("select * from Category")
    fun findAll():LiveData<List<Category>>

    @Query("select * from Category where name = :id")
    fun findById(id:String):LiveData<Category>

    @Insert
    fun create(c:Category)

    @Delete
    fun delete(c:Category)
}