package com.github.italord0

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.italord0.components.ContactSection
import com.github.italord0.components.FooterSection
import com.github.italord0.components.TopBar
import com.github.italord0.screens.BlogScreen
import com.github.italord0.screens.HomeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Column {
        val navController = rememberNavController()
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()

        TopBar {
            navController.navigate(it)
            coroutineScope.launch {
                scrollState.animateScrollTo(0)
            }
        }

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