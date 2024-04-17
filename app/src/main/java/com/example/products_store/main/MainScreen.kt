package com.example.products_store.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.products_store.MainNavigation

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(modifier = modifier.fillMaxWidth()) {
                BottomNavigationBar(navController = navController)
            }
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {}) {
//                Icon(Icons.Filled.Add, "Add")
//            }
//        } fixme add product
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
            MainNavigation(
                modifier = Modifier,
                navController = navController,
            )
        }
    }
}