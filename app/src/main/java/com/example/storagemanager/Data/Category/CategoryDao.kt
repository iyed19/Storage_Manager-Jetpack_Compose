package com.example.storagemanager.Data.Category

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

//    @Update
//    suspend fun updateProduct(product: Product)
//
//    @Delete
//    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM categories_data_table")
    fun getAllCategories(): List<Category>
}