package com.example.products_store.ui

import android.content.Context

class ThemeStateProvider(
    private val context: Context
) {

    fun getThemeState(): ThemeState {
        return if (ThemeState.isInitialized()) {
            ThemeState
        } else {
            ThemeState(ThemeStateFactory(context))
        }
    }

}