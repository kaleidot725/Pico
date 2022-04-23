package resource

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun MainTheme(isDarkMode: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        content = content,
        colors = if (isDarkMode) darkThemeColors else lightThemeColors
    )
}

private val lightThemeColors = lightColors(
    primary = Colors.md_theme_light_primary,
    onPrimary = Colors.md_theme_light_onPrimary,
    secondary = Colors.md_theme_light_secondary,
    onSecondary = Colors.md_theme_light_onSecondary,
    error = Colors.md_theme_light_error,
    onError = Colors.md_theme_light_onError,
    background = Colors.md_theme_light_background,
    onBackground = Colors.md_theme_light_onBackground,
    surface = Colors.md_theme_light_surface,
    onSurface = Colors.md_theme_light_onSurface,
)

private val darkThemeColors = darkColors(
    primary = Colors.md_theme_dark_primary,
    onPrimary = Colors.md_theme_dark_onPrimary,
    secondary = Colors.md_theme_dark_secondary,
    onSecondary = Colors.md_theme_dark_onSecondary,
    error = Colors.md_theme_dark_error,
    onError = Colors.md_theme_dark_onError,
    background = Colors.md_theme_dark_background,
    onBackground = Colors.md_theme_dark_onBackground,
    surface = Colors.md_theme_dark_surface,
    onSurface = Colors.md_theme_dark_onSurface,
)
