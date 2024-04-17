package com.example.products_store.domain.repository

import com.example.products_store.domain.models.Store
import retrofit2.http.GET

interface StoreApi {
    @GET("products")
    suspend fun getStore(): Store
}