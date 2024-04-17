package com.example.products_store.data.models

import com.example.products_store.domain.models.Store

sealed class Response {
    data class Success(val data: Store) : Response()
    data class Error(val error: Throwable) : Response()
}