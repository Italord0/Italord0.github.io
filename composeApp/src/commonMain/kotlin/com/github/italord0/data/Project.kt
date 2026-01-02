package com.github.italord0.data

import org.jetbrains.compose.resources.DrawableResource

data class Project(
    val image: DrawableResource,
    val name: String,
    val description: String,
    val platforms: List<Platform>,
    val codeLink: String? = null,
    val webLink: String? = null,
    val playstoreLink: String? = null,
)

enum class Platform {
    ANDROID,
    IOS,
    DESKTOP
}