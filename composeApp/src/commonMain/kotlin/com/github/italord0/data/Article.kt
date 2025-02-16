package com.github.italord0.data

import org.jetbrains.compose.resources.DrawableResource

data class Article(
    val image : DrawableResource,
    val title: String,
    val description: String,
    val link: String,
    val date: String
)
