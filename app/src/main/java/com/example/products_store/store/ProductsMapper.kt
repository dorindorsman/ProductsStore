package com.example.products_store.store

import android.util.Log
import com.example.products_store.domain.models.Product
import com.example.products_store.local.ProductEntity

object ProductsMapper {

    const val TAG = "ProductsMapper"

    fun mapProductEntityToProduct(productsEntityList: List<ProductEntity>): List<Product> {
        Log.d(TAG, "mapProductEntityToProduct")
        return productsEntityList.map { entity ->
            refactorProductEntityToProduct(entity)
        }
    }

    fun refactorProductEntityToProduct(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            rating = entity.rating,
            price = entity.price,
            discountPercentage = entity.discountPercentage,
            stock = entity.stock,
            brand = entity.brand,
            category = entity.category,
            thumbnail = entity.thumbnail,
            images = entity.images, //fixme
            favorite = entity.favorite
        )
    }

    fun mapProductToProductEntity(productsList: List<Product>): List<ProductEntity> {
        Log.d(TAG, "mapProductToProductEntity")
        return productsList.map { product ->
            refactorProductToProductEntity(product)
        }
    }

    fun refactorProductToProductEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            title = product.title,
            description = product.description,
            rating = product.rating,
            price = product.price,
            discountPercentage = product.discountPercentage,
            stock = product.stock,
            brand = product.brand,
            category = product.category,
            thumbnail = product.thumbnail,
            images = product.images, //fixme
            favorite = product.favorite
        )
    }

}