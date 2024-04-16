package com.example.products_store

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.products_store.MainPage.Login
import com.example.products_store.MainPage.Product
import com.example.products_store.MainPage.Shop
import com.example.products_store.store.ShopView
import com.example.products_store.store.StoreViewModelFactory

object MainPage {
    const val Login = "Login"
    const val Shop = "Shop"
    const val Product = "Product"
}

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier,
) {

    val appContext = LocalContext.current.applicationContext
    NavHost(navController, startDestination = Shop, modifier = modifier) {

        composable(route = Login) {

        }

        composable(route = Shop) {
            ShopView(
                viewModel(
                    factory = StoreViewModelFactory()
                )
            )
        }

        composable(route = Product) {

        }
    }
}