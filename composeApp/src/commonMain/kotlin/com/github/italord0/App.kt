package com.github.italord0

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.italord0.components.TopBar
import com.github.italord0.screens.BlogScreen
import com.github.italord0.screens.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Column {
        val navController = rememberNavController()

        TopBar { navController.navigate(it) }

        NavHost(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            navController = navController, startDestination = "Home"
        ) {
            composable(route = "Home") {
                HomeScreen()
            }

            composable(route = "Blog") {
                BlogScreen()
            }
        }
    }
}