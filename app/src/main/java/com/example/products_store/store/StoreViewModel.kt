package com.example.products_store.store

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
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
        Log.d(TAG, "$event")
        when (event) {
            is StoreEvent.SetProductFavorite -> {
                setProductFavorite(event.isFavorite, event.id)
                updateProductFavoriteDB(event.isFavorite, event.id)
            }
        }
    }

    fun handle(event: Lifecycle.Event) {
        Log.d(TAG, "$event")
        when (event) {
            Lifecycle.Event.ON_START -> onStart()
            else -> Unit
        }
    }

    private fun onStart() {
        Log.d(TAG, "onStart")
        setProductList()
    }

    private fun setProductFavorite(isFavorite: Boolean, id: Int) {
        Log.d(TAG, "setProductFavorite")
        val newProduct = mutableListOf<Product>()
        newProduct.addAll(
            products.map {
                if (it.id == id) {
                    it.favorite = isFavorite
                }
                it
            }
        )
        products = newProduct
    }

    private fun updateProductFavoriteDB(isFavorite: Boolean, id: Int) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "updateProductFavoriteDB")
        val product = products.filter {
            it.id == id
        }[0]

        product.favorite = isFavorite
        val entity = ProductsMapper.refactorProductToProductEntity(product)
        productRepository.setProduct(entity)
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
            products = ProductsMapper.mapProductEntityToProduct(it).toMutableStateList()
        }
    }

    private fun getRemoteProducts() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "getRemoteProducts")

        storeRepository.getStore().also { response ->
            if (response is Response.Success) {
                Log.d(TAG, "${response.data}")
                products = response.data.products.toMutableStateList()
                initLocalDatabase()
            } else if (response is Response.Error) {
                response.apply {
                    Log.e(TAG, "${error.message}")
                }
            }
        }
    }

    private fun initLocalDatabase() {
        Log.d(TAG, "initLocalDatabase")
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.insertAll(ProductsMapper.mapProductToProductEntity(products))
        }
    }

}