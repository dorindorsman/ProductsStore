package com.example.products_store.domain.models

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("products")
    var products: List<Product> = emptyList(),

    @SerializedName("total")
    var total: Int? = null,

    @SerializedName("skip")
    var skip: Int? = null,

    @SerializedName("limit")
    var limit: Int? = null,
)
