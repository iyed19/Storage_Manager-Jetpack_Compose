package com.example.storagemanager.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.storagemanager.Data.Category.Category
import com.example.storagemanager.Data.Category.CategoryDao
import com.example.storagemanager.Data.Product.Product
import com.example.storagemanager.Data.Product.ProductDao

@Database(entities = [Product::class, Category::class], version = 1)
abstract class AppRoomDB: RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppRoomDB? = null

        fun getDatabase(context: Context): AppRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDB::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}