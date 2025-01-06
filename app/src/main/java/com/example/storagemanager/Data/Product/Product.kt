package com.example.storagemanager.Data.Product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "products_data_table")
data class Product(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo("product_id")
    val id: Int = 0,

    //@ForeignKey
    @ColumnInfo("product_category")
    val category: String,

    @ColumnInfo("product_title")
    val title: String,

    @ColumnInfo("product_price")
    val price: Float,

    @ColumnInfo("product_quantity")
    val quantity: Int,

//    @ColumnInfo("product_description")
//    val description: String,
//
//    @ColumnInfo("product_buying_date")
//    val buyingDate: Date,


)