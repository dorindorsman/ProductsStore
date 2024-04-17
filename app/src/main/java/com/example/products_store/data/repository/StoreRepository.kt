package com.example.products_store.data.repository

import android.util.Log
import com.example.products_store.data.models.Response
import com.example.products_store.domain.repository.StoreApi

class StoreRepository (
    private val api: StoreApi
) {
    companion object {
        const val TAG = "StoreRepository"
    }

    suspend fun getStore(): Response {
        Log.d(TAG, "getStore")

        val response = try {
            api.getStore()
        } catch (exception: Exception) {
            return Response.Error(exception)
        }
        return Response.Success(response)
    }

}