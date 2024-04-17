package com.example.products_store.settings.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object ThemeRepository {

    var isDarkTheme by mutableStateOf(AppTheme.System)

    @Composable
    fun onThemeChange(isDarkTheme: AppTheme): Boolean {
        return when (isDarkTheme) {
            AppTheme.Light -> false
            AppTheme.Dark -> true
            AppTheme.System -> isSystemInDarkTheme()
        }
    }

}