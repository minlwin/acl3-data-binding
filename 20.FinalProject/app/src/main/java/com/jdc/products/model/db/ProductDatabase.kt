package com.jdc.products.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jdc.products.model.db.entity.Category
import com.jdc.products.model.db.entity.Product
import com.jdc.products.model.db.repo.CategoryRepo
import com.jdc.products.model.db.repo.ProductRepo

@Database(
    entities = [
        Category::class,
        Product::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun categoryRepo():CategoryRepo
    abstract fun productRepo():ProductRepo

    companion object {
        private lateinit var db:ProductDatabase

        fun getDatabase(context: Context):ProductDatabase =
            if(::db.isInitialized) db else
                Room.databaseBuilder(context, ProductDatabase::class.java, "com.jdc.products.database")
                    .build().also {
                        db = it
                    }
    }
}