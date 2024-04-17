package com.example.products_store.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products_store.settings.theme.ThemeRepository

class SettingsViewModelFactory(private var themeRepository: ThemeRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return SettingsViewModel(themeRepository) as T
    }
}





