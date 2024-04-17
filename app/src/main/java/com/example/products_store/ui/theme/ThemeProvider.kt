package com.example.products_store.ui.theme

import android.content.Context
import com.example.products_store.ui.StateFactory

class ThemeStateProvider(
    private val context: Context
) {

    fun getThemeState(): ThemeState {
        return if (ThemeState.isInitialized()) {
            ThemeState
        } else {
            ThemeState(StateFactory(context))
        }
    }

}