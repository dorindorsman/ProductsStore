package com.example.products_store.ui.language

import android.app.LocaleManager
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object LanguageUtils {

    private const val TAG = "LanguageUtils"

    fun getSystemLanguage(): String {
        Log.d(TAG, "getSystemLanguage")
        return Resources.getSystem().configuration.locale.language
    }

    fun setAppLanguage(context: Context, appLanguage: String) {
        Log.d(TAG, "setAppLanguage $appLanguage")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Log.d(TAG, "setAppLanguage if")
            context.getSystemService(LocaleManager::class.java).applicationLocales = LocaleList.forLanguageTags(appLanguage)
        } else {
            Log.d(TAG, "setAppLanguage else")
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(appLanguage))
        }
    }

}