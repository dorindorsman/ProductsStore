package com.example.products_store.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.ui.ThemeStateProvider

class SettingsViewModelFactory(private val appContext: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val themeState = ThemeStateProvider(appContext).getThemeState()

        return SettingsViewModel(themeState) as T
    }
}





