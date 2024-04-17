package com.example.products_store.products

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.local.AppDatabaseProvider
import com.example.products_store.local.ProductRepository

class ProductsViewModelFactory(private val appContext: Context,private val productId: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabaseProvider.provide(appContext)
        val productRepository = ProductRepository(appDatabase.productDao())

        return ProductsViewModel(productRepository, productId) as T
    }
}





