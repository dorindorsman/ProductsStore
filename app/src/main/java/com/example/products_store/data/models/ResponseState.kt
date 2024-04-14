package com.example.products_store.data.models

import com.example.products_store.domain.models.Shop

sealed class Response {
    data class Success(val data: Shop) : Response()
    data class Error(val error: Throwable) : Response()
}