package com.example.products_store.products

sealed class ProductsEvent {
    data object GetShop: ProductsEvent()
}