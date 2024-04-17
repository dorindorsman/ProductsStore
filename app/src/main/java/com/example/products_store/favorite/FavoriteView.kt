package com.example.products_store.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.example.products_store.store.product_store.ProductShopView
import com.example.products_store.utils.observe

@Composable
fun FavoriteView(
    navigateToProduct: (id: Int) -> Unit,
    viewModel: FavoriteViewModel
    ) {

        LocalLifecycleOwner.current.lifecycle.observe {
            viewModel.handle(it)
        }

        Column(modifier = Modifier.padding(horizontal = 12.dp)) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                items(viewModel.favoriteProducts.size) { i ->
                    ProductShopView(product = viewModel.favoriteProducts[i], navigateToProduct = navigateToProduct)
                }
            }

        }


    }
