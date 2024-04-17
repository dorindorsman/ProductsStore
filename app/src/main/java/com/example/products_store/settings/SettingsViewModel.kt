package com.example.products_store.settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products_store.data.models.AppTheme
import com.example.products_store.ui.ThemeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val themeState: ThemeState
) : ViewModel() {

    companion object {
        const val TAG = "SettingsViewModel"
    }

    private val _currentLanguage = MutableLiveData("English")
    val currentLanguage: LiveData<String> = _currentLanguage


    fun handle(event: SettingsEvent) {
        Log.d(TAG, "handle")
        when (event) {
            SettingsEvent.SetLanguage -> {}
            is SettingsEvent.UpdateTheme -> {
                updateTheme(event.theme)
            }

            SettingsEvent.Logout -> {}
        }
    }

    fun getTheme() = themeState.theme

    private fun updateTheme(theme: AppTheme) = viewModelScope.launch(Dispatchers.IO) {
        Log.d(TAG, "updateTheme")
        themeState.updateTheme(theme)
    }

    private fun setLanguage(language: String) {
        _currentLanguage.value = language
    }

    private fun logOut() {
        // Implement logout functionality, possibly needing to interact with a repository
    }


}