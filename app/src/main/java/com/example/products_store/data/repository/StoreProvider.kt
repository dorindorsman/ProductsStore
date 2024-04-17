package com.example.products_store.data.repository

import com.example.products_store.domain.repository.StoreApi
import retrofit2.converter.gson.GsonConverterFactory

object StoreProvider {

    fun provide(): StoreApi {
        return retrofit2.Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
            .create(StoreApi::class.java)
    }

}