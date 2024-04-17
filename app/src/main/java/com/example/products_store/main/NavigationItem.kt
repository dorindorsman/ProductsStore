package com.example.products_store.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.products_store.R

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: Int) {
    object Store : NavigationItem("Store", Icons.Rounded.Home, R.string.store)
    object Favorite : NavigationItem("Favorite", Icons.Rounded.Favorite, R.string.favorite) //fixme
    object Settings : NavigationItem("Settings", Icons.Rounded.Settings, R.string.settings) //fixme
}