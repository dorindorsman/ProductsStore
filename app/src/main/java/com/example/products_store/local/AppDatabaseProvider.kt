package com.example.products_store.local

import android.content.Context
import androidx.room.Room

object AppDatabaseProvider {

    const val DATABASE_NAME = "product_store_db"
    private var INSTANCE : AppDatabase? = null

    fun provide(context: Context): AppDatabase {
       if(INSTANCE == null){
           INSTANCE = Room.databaseBuilder(
               context,
               AppDatabase::class.java,
               DATABASE_NAME
           ).build()
       }

        return INSTANCE!!
    }

}