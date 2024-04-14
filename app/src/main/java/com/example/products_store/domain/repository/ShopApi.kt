package com.example.products_store.domain.repository

import com.example.products_store.domain.models.Shop
import retrofit2.http.GET

interface ShopApi {
    @GET("products")
    suspend fun getShop(): Shop
}