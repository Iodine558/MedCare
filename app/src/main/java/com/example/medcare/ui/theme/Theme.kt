package com.example.medcare.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

/**
 * Screen size categories based on Material 3 Window Size Classes.
 */
enum class MedCareWindowSizeClass {
    COMPACT_SMALL,  // < 360dp (Small phones)
    COMPACT_NORMAL, // 360dp .. 599dp (Standard phones)
    MEDIUM,         // 600dp .. 839dp (Tablets portrait / Foldables)
    EXPANDED        // >= 840dp (Tablets landscape / Desktop)
}

/**
 * CompositionLocal to access the current screen's responsive text scale factor.
 */
val LocalResponsiveTextScale = staticCompositionLocalOf { 1.0f }

/**
 * CompositionLocal to access the current window size class.
 */
val LocalMedCareWindowSizeClass = staticCompositionLocalOf { MedCareWindowSizeClass.COMPACT_NORMAL }

/**
 * Calculates the responsive scale factor based on screen width.
 * Baseline screen width is 360dp (scale 1.0f).
 */
fun calculateResponsiveTextScale(screenWidthDp: Int): Float {
    return when {
        screenWidthDp < 360 -> (screenWidthDp / 360f).coerceIn(0.85f, 0.98f)
        screenWidthDp in 360..599 -> 1.0f + ((screenWidthDp - 360) / 2400f)
        screenWidthDp in 600..839 -> 1.18f + ((screenWidthDp - 600) / 1600f)
        else -> (1.35f + ((screenWidthDp - 840) / 3000f)).coerceAtMost(1.5f)
    }
}

/**
 * Determines the WindowSizeClass from screen width.
 */
fun getMedCareWindowSizeClass(screenWidthDp: Int): MedCareWindowSizeClass {
    return when {
        screenWidthDp < 360 -> MedCareWindowSizeClass.COMPACT_SMALL
        screenWidthDp < 600 -> MedCareWindowSizeClass.COMPACT_NORMAL
        screenWidthDp < 840 -> MedCareWindowSizeClass.MEDIUM
        else -> MedCareWindowSizeClass.EXPANDED
    }
}

@Composable
fun MedCareTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    val textScaleFactor = remember(screenWidthDp) {
        calculateResponsiveTextScale(screenWidthDp)
    }

    val windowSizeClass = remember(screenWidthDp) {
        getMedCareWindowSizeClass(screenWidthDp)
    }

    val currentDensity = LocalDensity.current
    val responsiveDensity = remember(currentDensity, textScaleFactor) {
        Density(
            density = currentDensity.density,
            fontScale = currentDensity.fontScale * textScaleFactor,
        )
    }

    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    val responsiveTypography = remember(textScaleFactor) {
        createResponsiveTypography(textScaleFactor)
    }

    CompositionLocalProvider(
        LocalDensity provides responsiveDensity,
        LocalResponsiveTextScale provides textScaleFactor,
        LocalMedCareWindowSizeClass provides windowSizeClass
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = responsiveTypography,
            content = content
        )
    }
}
