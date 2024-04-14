package com.example.payplus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.payplus.MainPage.Billing
import com.example.payplus.MainPage.BillingItem


object MainPage {
    const val Billing = "Billing"
    const val BillingItem = "BillingItem"
}

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier,
) {

    val appContext = LocalContext.current.applicationContext
    NavHost(navController, startDestination = Billing, modifier = modifier) {
        composable(route = Billing) {

        }

        composable(route = BillingItem) {

        }
    }

}