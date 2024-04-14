package com.example.products_store.data.repository

import android.util.Log
import com.example.products_store.data.models.Response
import com.example.products_store.domain.repository.ShopApi

class ShopRepository (
    private val api: ShopApi
) {
    companion object {
        const val TAG = "ShopRepository"
    }

    suspend fun getShop(): Response {
        Log.d(TAG, "getShop")

        val response = try {
            api.getShop()
        } catch (exception: Exception) {
            return Response.Error(exception)
        }
        return Response.Success(response)
    }

}