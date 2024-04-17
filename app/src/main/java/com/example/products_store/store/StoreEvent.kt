package com.example.products_store.store

sealed class StoreEvent {
    data class SetProductFavorite(val isFavorite: Boolean, val id: Int): StoreEvent()
}