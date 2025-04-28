package com.example.myfootballapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TeamEntity::class, PlayerEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}