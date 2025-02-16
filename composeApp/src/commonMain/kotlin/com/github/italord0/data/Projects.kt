package com.github.italord0.data

import home_page.composeapp.generated.resources.*
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.champions
import home_page.composeapp.generated.resources.ip
import home_page.composeapp.generated.resources.myweather

object Projects {
    val data = listOf(
        Project(
            image = Res.drawable.ip,
            name = "What Is My IP?",
            description = "Simple Android App to display IP address using web-scrapping",
            platforms = listOf(Platform.ANDROID),
            codeLink = "https://github.com/Italord0/ipconfig"
        ),
        Project(
            image = Res.drawable.myweather,
            name = "MyWeather",
            description = "Android weather App using OpenWeather API",
            platforms = listOf(Platform.ANDROID),
            codeLink = "https://github.com/Italord0/MyWeather"
        ),
        Project(
            image = Res.drawable.champions,
            name = "Champions",
            description = "This is a simple iOS App to display FIFA World Champions",
            platforms = listOf(Platform.IOS),
            codeLink = "https://github.com/Italord0/champions-ios"
        ),
        Project(
            image = Res.drawable.flappy,
            name = "Flappy Clone",
            description = "A Clone of the popular game Flappy Bird using LibGDX game framework",
            platforms = listOf(Platform.ANDROID, Platform.DESKTOP),
            codeLink = "https://github.com/Italord0/flappy-bird"
        ),
        Project(
            image = Res.drawable.compose,
            name = "GOT Characters",
            description = "Compose Multiplatform App for displaying Game of Thrones Characters from API",
            platforms = listOf(Platform.ANDROID, Platform.IOS, Platform.DESKTOP),
            codeLink = "https://github.com/Italord0/got-characters"
        ),
        Project(
            image = Res.drawable.remind_me,
            name = "Remind Me",
            description = "Android Reminder App that uses Notification",
            platforms = listOf(Platform.ANDROID),
            codeLink = "https://github.com/Italord0/remind-me"
        ),
    )
}