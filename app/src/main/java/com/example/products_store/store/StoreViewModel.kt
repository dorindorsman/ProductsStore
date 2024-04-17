package com.example.products_store.store

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.data.models.Response
import com.example.products_store.data.repository.StoreRepository
import com.example.products_store.domain.models.Product
import com.example.products_store.local.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoreViewModel(
    private val storeRepository: StoreRepository,
    private val productRepository: ProductRepository
) : ViewModel() {

    companion object {
        const val TAG = "StoreViewModel"
    }

    var products: List<Product> by mutableStateOf(
        emptyList()
    )

    fun handle(event: StoreEvent) {
        when (event) {
            // StoreEvent.GetStore -> TODO()
            else -> {}
        }
    }

    fun handle(event: Lifecycle.Event) {
        Log.d(TAG,"$event")
        when (event) {
            Lifecycle.Event.ON_START -> onStart()
            else -> Unit
        }
    }

    private fun onStart() {
        setProductList()
    }

    private fun setProductList() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "setProductList")
        productRepository.isEmpty().collect { count ->
            if (count != 0) {
                getLocalProducts()
            } else {
                getRemoteProducts()
            }
        }
    }

    private fun getLocalProducts() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "getLocalProducts")
        productRepository.getAllProducts().collect {
            products = ProductsMapper.mapProductEntityToProduct(it)
        }
    }


    private fun getRemoteProducts() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "getRemoteProducts")

        storeRepository.getStore().also { response ->
            if (response is Response.Success) {
                Log.d(TAG, "${response.data}")
                products = response.data.products
                initLocalDatabase()
            } else if (response is Response.Error) {
                response.apply {
                    Log.e(TAG, "${error.message}")
                }
            }
        }
    }

    private fun initLocalDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.insertAll(ProductsMapper.mapProductToProductEntity(products))
        }
    }

//    private fun orderShop() {
//        Log.d(TAG, "orderShop")
//        shopCategories = shop.products.groupBy {
//            it.category
//        }.toList()
//    }

}