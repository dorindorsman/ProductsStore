package com.example.products_store.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.products_store.data.models.AppTheme
import com.example.products_store.data.repository.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object ThemeState : (ThemeStateFactory) -> ThemeState {

    private const val TAG = "ThemeState"

    var theme by mutableStateOf(AppTheme.System)

    private lateinit var settingsRepository: SettingsRepository
    private var typeInitialized = false

    override fun invoke(factory: ThemeStateFactory): ThemeState {
        Log.d(TAG, "invoke")
        settingsRepository = factory.getSettingsRepository()
        return this
    }

    fun isInitialized() = this::settingsRepository.isInitialized

    fun initState() {
        Log.d(TAG, "initState")
        if (typeInitialized) {
            return
        }

        Log.d(TAG, "setState")
        val liveData : LiveData<String> = settingsRepository.readAppTheme.asLiveData()
        theme = AppTheme.valueOf(liveData.value ?: AppTheme.System.name)
        typeInitialized = true
    }

    suspend fun updateTheme(appTheme: AppTheme) {
        Log.d(TAG, "updateTheme")
        theme = appTheme
        settingsRepository.persistAppTheme(appTheme)
    }

}
