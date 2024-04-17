package com.example.products_store.ui.language

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.products_store.data.models.AppLanguage
import com.example.products_store.data.repository.SettingsRepository
import com.example.products_store.ui.StateFactory

object LanguageState : (StateFactory) -> LanguageState {

    private const val TAG = "LanguageState"

    var language by mutableStateOf(AppLanguage.System)

    private lateinit var settingsRepository: SettingsRepository
    private var languageInitialized = false

    override fun invoke(factory: StateFactory): LanguageState {
        Log.d(TAG, "invoke")
        settingsRepository = factory.getSettingsRepository()
        return this
    }

    fun isInitialized() = this::settingsRepository.isInitialized

    fun initLanguage(owner: LifecycleOwner) {
        Log.d(TAG, "initLanguage")
        if (languageInitialized) {
            return
        }

        Log.d(TAG, "setLanguage")
        val liveData: LiveData<String> = settingsRepository.readAppLanguage.asLiveData()
        liveData.observe(owner){
            language = AppLanguage.valueOf(it)
        }
        languageInitialized = true
    }

    suspend fun updateLanguage(appLanguage: AppLanguage) {
        Log.d(TAG, "updateLanguage")
        language = appLanguage
        settingsRepository.persistAppLanguage(appLanguage)
    }
}
