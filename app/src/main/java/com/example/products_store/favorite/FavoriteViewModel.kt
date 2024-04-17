package com.example.products_store.favorite

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.domain.models.Product
import com.example.products_store.local.ProductRepository
import com.example.products_store.store.ProductsMapper.mapProductEntityToProduct
import com.example.products_store.store.StoreViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {

    companion object {
        const val TAG = "FavoriteViewModel"
    }

    var favoriteProducts: List<Product> by mutableStateOf(
        emptyList()
    )

    fun handle(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.SetProductFavorite -> {setProductFavorite(event.isFavorite, event.id)}
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
        setFavorites()
    }

    private fun setProductFavorite(isFavorite: Boolean, id: Int) {
        Log.d(StoreViewModel.TAG, "setProductFavorite")
        val newProduct = mutableListOf<Product>()
        newProduct.addAll(
            favoriteProducts.map {
                if (it.id == id) {
                    it.favorite = isFavorite
                }
                it
            }
        )
        favoriteProducts = newProduct
    }


    private fun setFavorites() = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "setFavorites")
        productRepository.getAllProducts().collect{ list ->
            favoriteProducts = mapProductEntityToProduct( list.filter { it.favorite })
        }
    }

}