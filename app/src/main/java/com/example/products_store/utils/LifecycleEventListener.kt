package com.example.products_store.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun Lifecycle.observe(callback: (Lifecycle.Event) -> Unit) {
    DisposableEffect(this) {
        val observer = LifecycleEventObserver { _, event ->
            callback(event)
        }
        addObserver(observer)
        onDispose {
            removeObserver(observer)
        }
    }
}


