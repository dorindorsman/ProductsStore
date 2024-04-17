package com.example.products_store.favorite

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.local.AppDatabaseProvider
import com.example.products_store.local.ProductRepository

class FavoriteViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabaseProvider.provide(context)
        val productRepository = ProductRepository(appDatabase.productDao())

        return FavoriteViewModel(
            productRepository
        ) as T
    }
}





