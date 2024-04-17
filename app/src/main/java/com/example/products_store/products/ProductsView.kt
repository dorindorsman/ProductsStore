package com.example.products_store.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.products_store.R
import com.example.products_store.utils.observe

@Composable
fun ProductView(viewModel: ProductsViewModel) {

    LocalLifecycleOwner.current.lifecycle.observe {
        viewModel.handle(it)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Icon(
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.End)
                .clickable {
                           //fixme
                },
            painter = if (viewModel.selectedProduct.favorite) {
                painterResource(id = R.drawable.ic_favorite)
            } else {
                painterResource(id = R.drawable.ic_favorite_border)
            },
            contentDescription = "favorite",
            tint = Color.Red
        )

        AsyncImage(
            model = viewModel.selectedProduct.thumbnail,
            modifier = Modifier
                .clip(RoundedCornerShape(70.dp))
                .size(250.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "Thumbnail Image",
            alignment = Alignment.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextDetails(stringResource(id = R.string.title), viewModel.selectedProduct.title.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.price), viewModel.selectedProduct.price.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.discountPercentage), viewModel.selectedProduct.discountPercentage.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.rating), viewModel.selectedProduct.rating.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.brand), viewModel.selectedProduct.brand.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.category), viewModel.selectedProduct.category)

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.stock), viewModel.selectedProduct.stock.toString())

        Spacer(modifier = Modifier.height(8.dp))

        TextDetails(stringResource(id = R.string.description), viewModel.selectedProduct.description.toString())

        Spacer(modifier = Modifier.height(8.dp))

        val scrollState = rememberScrollState()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            viewModel.selectedProduct.images?.forEach { imageUrl ->
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    model = imageUrl,
                    modifier = Modifier
                        .clip(RoundedCornerShape(17.dp))
                        .size(150.dp)
                        .padding(4.dp),
                    contentDescription = "Images",
                    alignment = Alignment.Center
                )
            }
        }
    }

}

@Composable
fun TextDetails(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 4.dp, top = 4.dp),
            text = key,
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .apply {
                    if (key == stringResource(id = R.string.description)) {
                        this.padding(start = 10.dp) //fixme
                    }
                }
                .padding(start = 4.dp),
            text = value,
            color = Color.DarkGray,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}