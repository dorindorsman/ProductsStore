package com.example.products_store.store

sealed class StoreEvent {
    data object GetStore: StoreEvent()
}