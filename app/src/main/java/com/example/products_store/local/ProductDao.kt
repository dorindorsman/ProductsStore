package com.example.products_store.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Data Access Object
@Dao
interface ProductDao {
    @Insert
    fun insertAll(products: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT (SELECT COUNT(id) FROM products)")
    fun getCount(): Flow<Int>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductById(id: Int): Flow<ProductEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun setProduct(entity: ProductEntity)


}