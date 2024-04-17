package com.example.products_store.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SettingsViewModelFactory(private var themeRepository: ThemeRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return SettingsViewModel(themeRepository) as T
    }
}





