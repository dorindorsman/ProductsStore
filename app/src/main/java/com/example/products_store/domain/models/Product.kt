package com.example.products_store.domain.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("discountPercentage")
    var discountPercentage: Double? = null,

    @SerializedName("rating")
    var rating: Double? = null,

    @SerializedName("stock")
    var stock: String? = null,

    @SerializedName("brand")
    var brand: String? = null,

    @SerializedName("category")
    var category: String = "",

    @SerializedName("thumbnail")
    var thumbnail: String? = null,

    @SerializedName("images")
    var images: List<String?>? = null,

    @SerializedName("favorite")
    var favorite: Boolean = false
)
