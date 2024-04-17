package com.example.products_store.ui.language

import android.content.Context
import com.example.products_store.ui.StateFactory

class LanguageStateProvider(
    private val context: Context
) {

    fun getLanguageState (): LanguageState {
        return if (LanguageState.isInitialized()) {
            LanguageState
        } else {
            LanguageState(StateFactory(context))
        }
    }

}