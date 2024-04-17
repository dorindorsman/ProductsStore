package com.example.products_store.product

sealed class ProductEvent {
    data object SetProductFavorite : ProductEvent()
}