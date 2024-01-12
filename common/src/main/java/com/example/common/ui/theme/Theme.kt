package com.example.common.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    background = colorBackgroundPrimary,
    onBackground = colorBackgroundPrimary.copy(alpha = 0.5f),
    primary = colorPrimaryContainer,
    onPrimary = colorPrimaryContainer.copy(alpha = 0.5f),
    secondary = colorSecondary,
    onSecondary = colorSecondary.copy(alpha = 0.5f),
    tertiary = colorText,
    onTertiary = colorText.copy(alpha = 0.5f),
    surface = Color.White.copy(alpha = 0.5f),
    onSurface = Color.White.copy(alpha = 0.2f),
    error = colorError,
    onError = colorError.copy(alpha = 0.5f)
)

private val LightColorScheme = lightColorScheme(
    background = colorBackgroundPrimary,
    onBackground = colorBackgroundPrimary.copy(alpha = 0.5f),
    primary = colorPrimaryContainer,
    onPrimary = colorPrimaryContainer.copy(alpha = 0.5f),
    secondary = colorSecondary,
    onSecondary = colorSecondary.copy(alpha = 0.5f),
    tertiary = colorText,
    onTertiary = colorText.copy(alpha = 0.5f),
    surface = Color.White.copy(alpha = 0.5f),
    onSurface = Color.White.copy(alpha = 0.2f),
    error = colorError,
    onError = colorError.copy(alpha = 0.5f)
)

@Composable
fun KBPrasacBankTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
}