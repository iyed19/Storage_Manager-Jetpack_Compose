package com.example.storagemanager.Data.Product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.storagemanager.Data.Category.Category

@Entity(tableName = "products_data_table",
    foreignKeys = [
        ForeignKey(
            entity = Category::class, // Parent entity
            parentColumns = ["category_id"], // Column in the parent table
            childColumns = ["product_category"], // Column in the child table
            onDelete = ForeignKey.CASCADE, // Delete products if category is deleted
            onUpdate = ForeignKey.CASCADE // Update category_id in products if category_id changes
        )
    ],
    indices = [Index(value = ["product_category"])] // Add index for faster joins
)
data class Product(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo("product_id")
    val id: Int = 0,

    @ColumnInfo("product_category") // Foreign key column
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