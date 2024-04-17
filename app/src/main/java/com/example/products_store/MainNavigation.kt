package com.example.products_store

import SettingsView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.products_store.MainPage.Favorite
import com.example.products_store.MainPage.Id
import com.example.products_store.MainPage.Login
import com.example.products_store.MainPage.ProductId
import com.example.products_store.MainPage.Settings
import com.example.products_store.MainPage.Store
import com.example.products_store.favorite.FavoriteView
import com.example.products_store.favorite.FavoriteViewModelFactory
import com.example.products_store.products.ProductView
import com.example.products_store.products.ProductsViewModelFactory
import com.example.products_store.settings.SettingsViewModelFactory
import com.example.products_store.store.StoreView
import com.example.products_store.store.StoreViewModelFactory

object MainPage {
    const val Login = "Login"
    const val Store = "Store"
    const val ProductId = "Product/{id}"
    const val Id = "id"
    const val Favorite = "Favorite"
    const val Settings = "Settings"
}

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier
) {
    val appContext = LocalContext.current.applicationContext
    NavHost(navController, startDestination = Store, modifier = modifier) {

        composable(route = Login) {

        }

        composable(route = Store) {
            StoreView(
                navigateToProduct = { id ->
                    navController.navigate(route = "Product/$id")
                },
                viewModel(
                    factory = StoreViewModelFactory(appContext)
                )
            )
        }

        composable(route = ProductId,
            arguments = listOf(
                navArgument(Id) {
                    type = NavType.IntType
                }
            )) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getInt(Id) ?: 0
            ProductView(
                viewModel(
                    factory = ProductsViewModelFactory(appContext, productId)
                )
            )
        }

        composable(route = Settings) {
            SettingsView(
                viewModel(
                    factory = SettingsViewModelFactory(appContext)
                )
            )
        }

        composable(route = Favorite) {
            FavoriteView(
                navigateToProduct = { id ->
                    navController.navigate(route = "Product/$id")
                },
                viewModel(
                    factory = FavoriteViewModelFactory(appContext)
                )
            )
        }
    }
}