package com.ruskaof.weatherapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.ruskaof.weatherapp.presentation.theme.AppTheme.LocalAppColors
import com.ruskaof.weatherapp.presentation.theme.AppTheme.LocalAppShapes
import com.ruskaof.weatherapp.presentation.theme.AppTheme.LocalAppTypography

@Composable
fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> darkColorPallet
        false -> lightColorPallet
    }

    val typography = when (darkTheme) {
        true -> darkTextTypography
        false -> lightTextTypography
    }

    val shapes = defaultShapes

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography,
        LocalAppShapes provides shapes,
        content = content
    )
}