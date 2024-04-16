package com.example.products_store.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.products_store.domain.models.Product

class ProductsViewModel (): ViewModel(){


    //    var productList by mutableStateOf(listOf<Product>())
//        private set

    var selectedProduct by mutableStateOf(
        Product()
    )

//    fun handle(event: CategoriesEvent) {
//        when (event) {
//            CategoriesEvent.GetShop -> getShop()
//        }
//    }
}
