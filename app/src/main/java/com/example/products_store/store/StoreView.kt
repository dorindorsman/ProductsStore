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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.products_store.store.product_store.ProductShopView
import com.example.products_store.R

@Composable
fun ShopView(
    viewModel: StoreViewModel
) {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        Text(
            text = stringResource(id = R.string.shop),
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 4.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(viewModel.shopProducts.size) { i ->
                ProductShopView(product = viewModel.shopProducts[i])
            }
        }

    }


}