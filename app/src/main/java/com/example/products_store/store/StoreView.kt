package com.example.products_store.store

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.products_store.store.product_store.ProductShopView
import com.example.products_store.R
import com.example.products_store.utils.observe

@Composable
fun StoreView(
    navigateToProduct: (id: Int) -> Unit,
    viewModel: StoreViewModel
) {

    LocalLifecycleOwner.current.lifecycle.observe {
        viewModel.handle(it)
    }

    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(viewModel.products.size) { i ->
                ProductShopView(product = viewModel.products[i], navigateToProduct = navigateToProduct)
            }
        }

    }

}