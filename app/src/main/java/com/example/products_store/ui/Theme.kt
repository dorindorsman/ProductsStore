package com.example.products_store.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import com.example.payplus.ui.Shapes
import com.example.payplus.ui.Typography
import com.example.payplus.ui.primaryColor
import com.example.payplus.ui.primaryDarkColor
import com.example.payplus.ui.primaryLightColor
import com.example.payplus.ui.secondaryColor
import com.example.payplus.ui.secondaryDarkColor
import com.example.payplus.ui.secondaryLightColor
import com.example.products_store.data.models.AppTheme

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = primaryDarkColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryDarkColor,
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryLightColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryLightColor,
)

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProductsStoreTheme(content: @Composable () -> Unit) {
    val isPreview = LocalInspectionMode.current
    if (isPreview.not()) {
        val context = LocalContext.current.applicationContext
        val themeState = ThemeStateProvider(context).getThemeState()
        themeState.initState()
    }

    val colors = if (isLightTheme()) LightColorPalette else DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun isLightTheme(
    isPreview: Boolean = LocalInspectionMode.current,
    context: Context = LocalContext.current
): Boolean {

    val theme = if (isPreview) {
        AppTheme.System
    } else {
        ThemeStateProvider(context).getThemeState().theme
    }

    return when (theme) {
        AppTheme.Light -> true
        AppTheme.Dark -> false
        AppTheme.System -> isSystemInDarkTheme().not()
    }
}