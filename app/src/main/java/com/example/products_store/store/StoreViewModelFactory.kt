package com.example.products_store.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.data.repository.StoreRepository
import com.example.products_store.domain.repository.ShopApi
import retrofit2.converter.gson.GsonConverterFactory

class StoreViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val retrofitBuilder = retrofit2.Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
            .create(ShopApi::class.java)

        return StoreViewModel(
            StoreRepository(retrofitBuilder)
        ) as T
    }
}





