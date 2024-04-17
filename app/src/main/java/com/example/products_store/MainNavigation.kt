package com.example.products_store

import SettingsView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.payplus.ui.ProductsStoreTheme
import com.example.products_store.MainPage.Login
import com.example.products_store.MainPage.Product
import com.example.products_store.MainPage.Settings
import com.example.products_store.MainPage.Store
import com.example.products_store.local.ProductRepository
import com.example.products_store.settings.SettingsViewModelFactory
import com.example.products_store.store.ShopView
import com.example.products_store.store.StoreViewModelFactory
import com.example.products_store.settings.theme.ThemeRepository
import com.example.products_store.settings.theme.ThemeRepository.isDarkTheme

object MainPage {
    const val Login = "Login"
    const val Store = "Store"
    const val Product = "Product"
    const val Settings = "Settings"
}

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier
) {

    ProductsStoreTheme(
        darkTheme = ThemeRepository.onThemeChange(isDarkTheme = isDarkTheme)
    ) {
        val appContext = LocalContext.current.applicationContext
        NavHost(navController, startDestination = Store, modifier = modifier) {

            composable(route = Login) {

            }

            composable(route = Store) {
                ShopView(
                    viewModel(
                        factory = StoreViewModelFactory(appContext)
                    )
                )
            }

            composable(route = Product) {

            }

            composable(route = Settings) {
                SettingsView(
                    viewModel(
                        factory = SettingsViewModelFactory(ThemeRepository)
                    )
                )
            }
        }



    }
}