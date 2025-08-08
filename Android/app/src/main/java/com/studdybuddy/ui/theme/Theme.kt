package com.studdybuddy.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = PrimaryColor,
    secondary = PrimaryTint,
    background = LightBackground,
    surface = LightCard,
)

private val DarkColors = darkColorScheme(
    primary = PrimaryShade,
    secondary = PrimaryTint,
    background = DarkBackground,
    surface = DarkCard,
)

@Composable
fun StuddyBuddyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.background.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
