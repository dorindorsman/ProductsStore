package com.example.products_store.ui

import android.content.Context
import com.example.products_store.data.repository.SettingsRepository

class ThemeStateFactory(context: Context) {

    private val appContext = context.applicationContext

    fun getSettingsRepository() = SettingsRepository(appContext)
}