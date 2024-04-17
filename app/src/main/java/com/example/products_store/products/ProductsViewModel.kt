package com.example.products_store.products

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.domain.models.Product
import com.example.products_store.local.ProductRepository
import com.example.products_store.store.ProductsMapper
import com.example.products_store.store.StoreViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productRepository: ProductRepository,
    private val productId: Int
) : ViewModel() {

    companion object {
        const val TAG = "ProductsViewModel"
    }

    var selectedProduct by mutableStateOf(
        Product()
    )

    fun handle(event: ProductsEvent) {
        Log.d(TAG, "handle $event")
        when (event) {
            ProductsEvent.SetProductFavorite -> {
                setProductFavorite()
                updateProductFavoriteDB()
            }
        }
    }

    fun handle(event: Lifecycle.Event) {
        Log.d(TAG, "handle $event")
        when (event) {
            Lifecycle.Event.ON_START -> onStart()
            else -> Unit
        }
    }


    private fun onStart() {
        Log.d(TAG, "onStart")
        getProduct()
    }

    private fun getProduct() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "getProduct")
        productRepository.getProductById(productId).collect {
            selectedProduct = ProductsMapper.refactorProductEntityToProduct(it)
            Log.d(TAG, selectedProduct.toString())
        }
    }

    private fun setProductFavorite() {
        Log.d(TAG, "setProductFavorite")
        selectedProduct = selectedProduct.copy(favorite =  selectedProduct.favorite.not())
        Log.d(TAG, "${selectedProduct.favorite}")
    }

    private fun updateProductFavoriteDB() = viewModelScope.launch(Dispatchers.IO) {
        val entity = ProductsMapper.refactorProductToProductEntity(selectedProduct)
        productRepository.setProduct(entity)
    }

}
