package com.example.medcare.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp

/**
 * Creates Material 3 Typography scaled according to screen size scale factor.
 */
fun createResponsiveTypography(scaleFactor: Float): Typography {
    val baseTypography = Typography()
    return Typography(
        displayLarge = baseTypography.displayLarge.copy(fontSize = (57 * scaleFactor).sp),
        displayMedium = baseTypography.displayMedium.copy(fontSize = (45 * scaleFactor).sp),
        displaySmall = baseTypography.displaySmall.copy(fontSize = (36 * scaleFactor).sp),
        headlineLarge = baseTypography.headlineLarge.copy(fontSize = (32 * scaleFactor).sp),
        headlineMedium = baseTypography.headlineMedium.copy(fontSize = (28 * scaleFactor).sp),
        headlineSmall = baseTypography.headlineSmall.copy(fontSize = (24 * scaleFactor).sp),
        titleLarge = baseTypography.titleLarge.copy(fontSize = (22 * scaleFactor).sp),
        titleMedium = baseTypography.titleMedium.copy(fontSize = (16 * scaleFactor).sp),
        titleSmall = baseTypography.titleSmall.copy(fontSize = (14 * scaleFactor).sp),
        bodyLarge = baseTypography.bodyLarge.copy(fontSize = (16 * scaleFactor).sp),
        bodyMedium = baseTypography.bodyMedium.copy(fontSize = (14 * scaleFactor).sp),
        bodySmall = baseTypography.bodySmall.copy(fontSize = (12 * scaleFactor).sp),
        labelLarge = baseTypography.labelLarge.copy(fontSize = (14 * scaleFactor).sp),
        labelMedium = baseTypography.labelMedium.copy(fontSize = (12 * scaleFactor).sp),
        labelSmall = baseTypography.labelSmall.copy(fontSize = (11 * scaleFactor).sp),
    )
}
