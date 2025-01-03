package com.example.storagemanager.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductRoomDB : RoomDatabase() {
    abstract fun productDao(): ProductDao
}