package com.example.payplus.ui

import android.provider.CalendarContract
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFF4FF46B)
val primaryLightColor = Color(0xFF8CFF9C)
val primaryDarkColor = Color(0xFF006D21)
val primaryTextColor = Color(0xFF000000)
val secondaryColor = Color(0xFF8E24AA)
val secondaryLightColor = Color(0xFFC158DC)
val secondaryDarkColor = Color(0xFF5C007A)
val secondaryTextColor = Color(0xFFFFFFFF)

val TerminalColor = Color(0xFF34AA53)


val CalendarContract.Colors.TerminalColor: Color
    @Composable
    get() = TerminalColor


