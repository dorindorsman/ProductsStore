package com.example.products_store.store

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.data.models.Response
import com.example.products_store.data.repository.StoreRepository
import com.example.products_store.domain.models.Product
import com.example.products_store.domain.models.Shop
import kotlinx.coroutines.launch

class StoreViewModel(
    private val storeRepository: StoreRepository
) : ViewModel() {

    companion object {
        const val TAG = "StoreViewModel"
    }

    init {
        getShop()
    }

    var shop by mutableStateOf(
        Shop()
    )

    var shopProducts: List<Product> by mutableStateOf(
        emptyList()
    )

    fun handle(event: StoreEvent) {
        when (event) {
            StoreEvent.GetStore -> getShop()
        }
    }

    private fun getShop() = viewModelScope.launch {
        Log.d(TAG, "getShop")
        storeRepository.getShop().also { response ->
            if (response is Response.Success) {
                Log.d(TAG, "${response.data}")
                shop = response.data
                shopProducts = shop.products
            } else if (response is Response.Error) {
                response.apply {
                    Log.e(TAG, "${error.message}")
                }
            }
        }
    }

//    private fun orderShop() {
//        Log.d(TAG, "orderShop")
//        shopCategories = shop.products.groupBy {
//            it.category
//        }.toList()
//    }

}