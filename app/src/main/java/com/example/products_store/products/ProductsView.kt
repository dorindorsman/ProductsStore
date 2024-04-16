package com.example.products_store.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ProductView(viewModel: ProductsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(viewModel.selectedProduct.thumbnail),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = viewModel.selectedProduct.title+"",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = viewModel.selectedProduct.description+"",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Price: $${String.format("%.2f", viewModel.selectedProduct.price)}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Discount: ${String.format("%.2f", viewModel.selectedProduct.discountPercentage)}%",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Rating: ${String.format("%.2f", viewModel.selectedProduct.rating)}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Brand: ${viewModel.selectedProduct.brand}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Category: ${viewModel.selectedProduct.category}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Stock: ${viewModel.selectedProduct.stock}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Images:",
            style = MaterialTheme.typography.body1
        )
        viewModel.selectedProduct.images?.forEach { imageUrl ->
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
        }
    }
}