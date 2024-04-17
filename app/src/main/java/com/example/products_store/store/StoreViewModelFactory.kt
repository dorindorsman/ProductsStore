package com.example.products_store.store

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.data.repository.StoreProvider
import com.example.products_store.data.repository.StoreRepository
import com.example.products_store.local.AppDatabaseProvider
import com.example.products_store.local.ProductRepository

class StoreViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabaseProvider.provide(context)
        val productRepository = ProductRepository(appDatabase.productDao())
        val storeRepository = StoreRepository(StoreProvider.provide())

        return StoreViewModel(
            storeRepository,
            productRepository,
        ) as T
    }
}





