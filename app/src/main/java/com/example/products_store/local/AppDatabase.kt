package com.example.products_store.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.products_store.login.UserEntity
import com.example.products_store.login.UserDao
import com.example.products_store.utils.ImageConverter

@Database(entities = [ProductEntity::class, UserEntity::class], version = 1)
@TypeConverters(ImageConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    abstract fun userDao(): UserDao

}