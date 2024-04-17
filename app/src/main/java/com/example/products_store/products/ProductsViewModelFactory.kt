package com.example.products_store.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.domain.repository.StoreApi
import retrofit2.converter.gson.GsonConverterFactory

class ProductsViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val retrofitBuilder = retrofit2.Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/") // Fixme - change ip
            .build()
            .create(StoreApi::class.java)

        return ProductsViewModel(
        ) as T
    }
}





