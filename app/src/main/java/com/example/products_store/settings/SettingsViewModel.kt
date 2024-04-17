package com.example.products_store.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.products_store.settings.ThemeRepository.isDarkTheme

class SettingsViewModel(val themeRepository: ThemeRepository) : ViewModel() {

    companion object {
        const val TAG = "SettingsViewModel"
    }

    private val _currentLanguage = MutableLiveData("English")
    val currentLanguage: LiveData<String> = _currentLanguage


    fun handle(event: SettingsEvent) {
        when (event) {
            SettingsEvent.SetLanguage -> {}
            SettingsEvent.SetThemeMode -> {toggleDarkMode(isDarkTheme)}
            SettingsEvent.Logout -> {}
        }
    }

    private fun toggleDarkMode(isDarkTheme: AppTheme) {
        //themeRepository.onThemeChange(isDarkTheme = isDarkTheme)
    }

    private fun setLanguage(language: String) {
        _currentLanguage.value = language
    }

    private fun logOut() {
        // Implement logout functionality, possibly needing to interact with a repository
    }


}