package com.example.products_store.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.products_store.utils.ImageConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String?,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String?,

    @SerializedName("price")
    @ColumnInfo(name = "price")
    var price: Int?,

    @SerializedName("discountPercentage")
    @ColumnInfo(name = "discountPercentage")
    var discountPercentage: Double?,

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    var rating: Double?,

    @SerializedName("stock")
    @ColumnInfo(name = "stock")
    var stock: String?,

    @SerializedName("brand")
    @ColumnInfo(name = "brand")
    var brand: String?,

    @SerializedName("category")
    @ColumnInfo(name = "category")
    var category: String,

    @SerializedName("thumbnail")
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String?,

    @SerializedName("images")
    @TypeConverters(ImageConverter::class)
    var images: List<String?>?,

    @SerializedName("favorite")
    @ColumnInfo(name = "favorite")
    var favorite: Boolean
)
