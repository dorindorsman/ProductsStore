package com.example.products_store.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.products_store.data.models.AppTheme
import com.example.products_store.data.repository.SettingsRepository
import com.example.products_store.ui.StateFactory

object ThemeState : (StateFactory) -> ThemeState {

    private const val TAG = "ThemeState"

    var theme by mutableStateOf(AppTheme.System)

    private lateinit var settingsRepository: SettingsRepository
    private var typeInitialized = false

    override fun invoke(factory: StateFactory): ThemeState {
        Log.d(TAG, "invoke")
        settingsRepository = factory.getSettingsRepository()
        return this
    }

    fun isInitialized() = this::settingsRepository.isInitialized

    fun initState(owner: LifecycleOwner) {
        Log.d(TAG, "initState")
        if (typeInitialized) {
            return
        }

        Log.d(TAG, "setState")
        val liveData : LiveData<String> = settingsRepository.readAppTheme.asLiveData()
        liveData.observe(owner){
            theme = AppTheme.valueOf(it)
        }
        Log.d(TAG, "${liveData.value}")
        typeInitialized = true
    }

    suspend fun updateTheme(appTheme: AppTheme) {
        Log.d(TAG, "updateTheme")
        theme = appTheme
        settingsRepository.persistAppTheme(appTheme)
    }

}
