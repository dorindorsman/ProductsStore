package com.example.products_store.settings

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.data.models.AppLanguage
import com.example.products_store.data.models.AppTheme
import com.example.products_store.ui.language.LanguageState
import com.example.products_store.ui.theme.ThemeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val themeState: ThemeState,
    private val languageState: LanguageState
) : ViewModel() {

    companion object {
        const val TAG = "SettingsViewModel"
    }

    fun handle(event: SettingsEvent) {
        Log.d(TAG, "handle")
        when (event) {
            is SettingsEvent.UpdateTheme -> {
                updateTheme(event.theme)
            }

            is SettingsEvent.UpdateLanguage -> {
                updateLanguage(event.language)
            }

            SettingsEvent.Logout -> {}
        }
    }

    fun getTheme() = themeState.theme

    fun getLanguage() = languageState.language


    private fun updateTheme(theme: AppTheme) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "updateTheme")
        themeState.updateTheme(theme)
    }

    private fun updateLanguage(language: AppLanguage) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "updateLanguage")
        languageState.updateLanguage(language)
    }

}