package com.github.italord0.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.italord0.components.AboutSection
import com.github.italord0.components.ContactSection
import com.github.italord0.components.HeaderSection
import com.github.italord0.components.ProjectsSection
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        HeaderSection()
        Spacer(modifier = Modifier.height(32.dp))
        AboutSection()
        Spacer(modifier = Modifier.height(48.dp))
        ProjectsSection()
        Spacer(modifier = Modifier.height(48.dp))
        ContactSection()
    }
}


@Preview
@Composable
fun AboutSectionPreview() {
    HeaderSection()
}