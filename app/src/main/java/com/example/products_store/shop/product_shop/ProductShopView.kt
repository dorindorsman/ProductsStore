package com.example.products_store.shop.product_shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.products_store.domain.models.Product

@Composable
fun ProductShopView(product: Product) {

    Row(
        modifier = Modifier
            .clickable {
                //Todo
            }
            .padding(bottom = 8.dp),
    ) {
//        AsyncImage(
//            model = product.thumbnail,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//            contentScale = ContentScale.Crop,
//            contentDescription = "Thumbnail Image"
//        )

        Column{

            Row(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = "Product title: ",
                    style = MaterialTheme.typography.body2
                )
                Text(text = product.title.toString())
            }

            Row(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = "Product Distinct Products: ",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = product.description.toString(),
                    style = MaterialTheme.typography.body2
                )  //fixme
            }

            Row(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = "Product Stock Products: ",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = product.price.toString(),
                    style = MaterialTheme.typography.body2
                ) //fixme
            }

            Row(modifier = Modifier.padding(start = 4.dp)) {
                Text(
                    text = "Product Stock Products: ",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = product.brand.toString(),
                    style = MaterialTheme.typography.body2
                ) //fixme
            }
        }

    }
}