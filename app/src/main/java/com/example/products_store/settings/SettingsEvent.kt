package com.example.products_store.settings

import com.example.products_store.data.models.AppTheme

sealed class SettingsEvent {
    data class UpdateTheme(val theme: AppTheme): SettingsEvent()
    data object SetLanguage: SettingsEvent()
    data object Logout: SettingsEvent()
}