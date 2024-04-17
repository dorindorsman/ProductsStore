package com.example.products_store.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    object Store : NavigationItem("Store", Icons.Rounded.Home, "Store")
    object Favorite : NavigationItem("Favorite", Icons.Rounded.Favorite, "Favorite") //fixme
    object Settings : NavigationItem("Settings", Icons.Rounded.Settings, "Settings") //fixme
}