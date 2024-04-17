package com.example.products_store.products

import com.example.products_store.store.StoreEvent

sealed class ProductsEvent {
    data object SetProductFavorite : ProductsEvent()
}