package com.github.italord0

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.italord0.components.FooterSection
import com.github.italord0.components.TopBar
import com.github.italord0.screens.BlogScreen
import com.github.italord0.screens.HomeScreen
import com.github.italord0.util.AppTheme
import com.github.italord0.util.LocalAppTheme
import com.github.italord0.util.darkTheme
import com.github.italord0.util.lightTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val systemDark = isSystemInDarkTheme()
    var isDarkMode by remember { mutableStateOf(systemDark) }

    AppTheme(theme = if (isDarkMode) darkTheme else lightTheme) {
        val theme = LocalAppTheme.current
        Column(modifier = Modifier.background(color = theme.colors.background)) {
            val navController = rememberNavController()
            val scrollState = rememberScrollState()
            val coroutineScope = rememberCoroutineScope()

            TopBar(
                isDarkMode = isDarkMode,
                onToggleDarkMode = {
                    isDarkMode = it
                },
                onRouteClicked = {
                    navController.navigate(it)
                    coroutineScope.launch {
                        scrollState.animateScrollTo(0)
                    }
                }
            )

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                NavHost(
                    navController = navController, startDestination = "Home"
                ) {
                    composable(route = "Home") {
                        HomeScreen()
                    }

                    composable(route = "Blog") {
                        BlogScreen()
                    }
                }
                FooterSection()
            }
        }
    }
}