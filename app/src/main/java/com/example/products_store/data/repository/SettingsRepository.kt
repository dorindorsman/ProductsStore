package com.example.products_store.data.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.products_store.data.models.AppTheme
import com.example.products_store.data.models.AppLanguage
import com.example.products_store.data.repository.SettingsRepository.Companion.PREFERENCE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

class SettingsRepository(
    context: Context
) {

    companion object {
        const val TAG = "SettingsRepository"
        const val PREFERENCE_NAME = "settings_preferences"
        const val PREFERENCE_THEME_KEY = "theme"
        const val PREFERENCE_LAN_KEY = "language"
    }

    private object PreferenceKeys {
        val themeKey = stringPreferencesKey(PREFERENCE_THEME_KEY)
        val lanKey = stringPreferencesKey(PREFERENCE_LAN_KEY)
    }

    private val dataStore = context.settingsDataStore

    suspend fun persistAppTheme(appTheme: AppTheme) {
        Log.d(TAG, "persistAppTheme")
        dataStore.edit { preference ->
            preference[PreferenceKeys.themeKey] = appTheme.name
        }
    }

    suspend fun persistAppLanguage(appLanguage: AppLanguage) {
        Log.d(TAG, "persistAppLanguage")
        dataStore.edit { preference ->
            preference[PreferenceKeys.lanKey] = appLanguage.name
        }
    }

    val readAppTheme: Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val appTheme = preferences[PreferenceKeys.themeKey] ?: AppTheme.System.name
            appTheme
        }

    val readAppLanguage: Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val appTheme = preferences[PreferenceKeys.lanKey] ?: AppLanguage.System.name
            appTheme
        }
}