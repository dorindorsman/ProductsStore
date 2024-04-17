package com.example.products_store.product

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.local.AppDatabaseProvider
import com.example.products_store.local.ProductRepository

class ProductViewModelFactory(private val appContext: Context, private val productId: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val appDatabase = AppDatabaseProvider.provide(appContext)
        val productRepository = ProductRepository(appDatabase.productDao())

        return ProductViewModel(productRepository, productId) as T
    }
}





