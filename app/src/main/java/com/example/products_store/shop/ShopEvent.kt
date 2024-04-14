package com.example.products_store.shop

sealed class ShopEvent {
    data object GetShop: ShopEvent()
}