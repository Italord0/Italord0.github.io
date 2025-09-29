package com.github.italord0.util

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalAppTheme = staticCompositionLocalOf {
    lightTheme
}

@Composable
fun AppTheme(
    theme: AppTheme = if (isSystemInDarkTheme()) darkTheme else lightTheme,
    content: @Composable () -> Unit
) {

    val colorChangeAnimationDuration = 1000

    val animatedColors = AppColors(
        primary = animateColorAsState(
            targetValue = theme.colors.primary,
            animationSpec = tween(durationMillis = colorChangeAnimationDuration)
        ).value,
        background = animateColorAsState(
            targetValue = theme.colors.background,
            animationSpec = tween(durationMillis = colorChangeAnimationDuration)
        ).value,
        text = animateColorAsState(
            targetValue = theme.colors.text, animationSpec = tween(durationMillis = colorChangeAnimationDuration)
        ).value,
        onBackground = animateColorAsState(
            targetValue = theme.colors.onBackground,
            animationSpec = tween(durationMillis = colorChangeAnimationDuration)
        ).value
    )

    val animatedTheme = AppTheme(colors = animatedColors)

    CompositionLocalProvider(LocalAppTheme provides animatedTheme) {
        content()
    }
}

data class AppTheme(
    val colors: AppColors
)

data class AppColors(
    val primary: Color,
    val background: Color,
    val onBackground: Color,
    val text: Color
)

val lightColors = AppColors(
    primary = Color.Red,
    background = Color.White,
    onBackground = Color.LightGray,
    text = Color.Black
)

val darkColors = AppColors(
    primary = Color.Red,
    background = Color.DarkGray,
    onBackground = Color.Gray,
    text = Color.White
)


val lightTheme = AppTheme(
    colors = lightColors
)

val darkTheme = AppTheme(
    colors = darkColors
)