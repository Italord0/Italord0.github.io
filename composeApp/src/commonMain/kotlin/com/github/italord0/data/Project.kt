package com.github.italord0.data

import org.jetbrains.compose.resources.DrawableResource

data class Project(
    val image: DrawableResource,
    val name: String,
    val description: String,
    val platforms: List<Platform>,
    val codeLink: String
)

enum class Platform {
    ANDROID,
    IOS,
    DESKTOP
}