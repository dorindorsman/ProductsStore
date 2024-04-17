package com.example.products_store.local

import kotlinx.coroutines.flow.Flow

class ProductRepository(private val productDao: ProductDao) {

    fun insertAll(products: List<ProductEntity>) {
        productDao.insertAll(products = products)
    }

    fun getAllProducts(): Flow<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    fun isEmpty(): Flow<Int> {
        return productDao.getCount()
    }

    fun getProductById(id: Int): Flow<ProductEntity> {
        return productDao.getProductById(id)
    }

    fun setProduct(entity: ProductEntity) {
        productDao.setProduct(entity)
    }
}