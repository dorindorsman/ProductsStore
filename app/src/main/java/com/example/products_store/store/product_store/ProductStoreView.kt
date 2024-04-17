package com.example.products_store.store.product_store

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.products_store.R
import com.example.products_store.domain.models.Product

@Composable
fun ProductShopView(product: Product, navigateToProduct: (id: Int) -> Unit, onClick: (product: Product) -> Unit) {

    Row(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .clip(MaterialTheme.shapes.small)
            .background(Color.LightGray)
            .fillMaxWidth()
            .clickable {
                navigateToProduct(product.id)
            },
    ) {

        Box {
            AsyncImage(
                model = product.thumbnail,
                modifier = Modifier
                    .size(200.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Thumbnail Image",
                alignment = Alignment.Center
            )
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .clickable { onClick(product) },
                painter = if (product.favorite) {
                    painterResource(id = R.drawable.ic_favorite)
                } else {
                    painterResource(id = R.drawable.ic_favorite_border)
                },
                contentDescription = "favorite",
                tint = Color.Red
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                text = stringResource(id = R.string.title),
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = product.title.toString(),
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


            Text(
                modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = product.description.toString(),
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                text = stringResource(id = R.string.price),
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = product.price.toString(),
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                text = stringResource(id = R.string.brand),
                style = MaterialTheme.typography.body2,
                color = Color.Gray,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = product.brand.toString(),
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}