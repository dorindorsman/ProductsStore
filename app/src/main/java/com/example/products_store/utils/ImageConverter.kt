package com.example.products_store.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImageConverter {
    @TypeConverter
    fun fromImageList(images: List<String?>?): String? {
        return Gson().toJson(images)
    }

    @TypeConverter
    fun toImageList(imagesString: String?): List<String?>? {
        val type = object : TypeToken<List<String?>>() {}.type
        return Gson().fromJson(imagesString, type)
    }
}