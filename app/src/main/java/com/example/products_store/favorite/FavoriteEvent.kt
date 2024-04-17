package com.example.products_store.favorite


sealed class FavoriteEvent {
   data class SetProductFavorite(val isFavorite: Boolean, val id: Int): FavoriteEvent()

}