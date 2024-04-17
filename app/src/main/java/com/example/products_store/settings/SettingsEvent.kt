package com.example.products_store.settings

import com.example.products_store.data.models.AppLanguage
import com.example.products_store.data.models.AppTheme

sealed class SettingsEvent {
    data class UpdateTheme(val theme: AppTheme): SettingsEvent()
    data class UpdateLanguage(val language: AppLanguage): SettingsEvent()
    data object Logout: SettingsEvent()
}