package com.example.storagemanager.Data.Category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_data_table")
data class Category(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo("category_id")
    val id: Int = 0,


    @ColumnInfo("category_name")
    val name: String,
)