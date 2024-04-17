package com.example.products_store.main

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Store,
        NavigationItem.Settings,
        NavigationItem.Favorite,
    )
    var selectedItem by remember { mutableIntStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Store.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(
        containerColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        items.forEachIndexed { index, item ->
            val selected = selectedItem == index
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = item.icon!!,
                        tint = if (selected) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onPrimary,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selected) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onPrimary,
                    )
                },
                selected = selected,
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}