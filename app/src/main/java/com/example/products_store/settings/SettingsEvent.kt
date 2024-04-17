package com.example.products_store.settings

sealed class SettingsEvent {
    data object SetThemeMode: SettingsEvent()
    data object SetLanguage: SettingsEvent()
    data object Logout: SettingsEvent()
}