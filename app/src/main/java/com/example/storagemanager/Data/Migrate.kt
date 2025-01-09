package com.example.storagemanager.Data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Example: Add a new column "description" to "Product" table
        database.execSQL("ALTER TABLE Product ADD COLUMN description TEXT DEFAULT NULL")
    }
}
