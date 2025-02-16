package com.github.italord0

import org.jetbrains.compose.web.renderComposable
import kotlinx.browser.document

fun main() {
    console.log("Starting Compose Web App")
    val rootElement = document.getElementById("root")
    if (rootElement == null) {
        console.error("Root element not found!")
        return
    }
    renderComposable(rootElementId = "root") {
        App()
    }
    console.log("Render complete")
}