package com.github.italord0.data

import home_page.composeapp.generated.resources.*

object Articles {
    val data = listOf(
        Article(
            image = Res.drawable.compose_multiplatform,
            title = "Compose Multiplatform : Building an app for Android, iOS and Desktop",
            description = "Learn Compose Multiplatform: Build apps for Android, iOS, and Desktop using JetBrains' toolkit for efficient, responsive development across multiple devices.",
            link = "https://medium.com/@italord.melo/compose-multiplatform-mvvm-ktor-building-an-app-with-patterns-for-android-ios-and-desktop-4ae01594887c",
            date = "Feb 3, 2024"
        ),
        Article(
            image = Res.drawable.voyager,
            title = "Voyager : Compose Multiplatform Navigation and ViewModels (ScreenModel)",
            description = "Seamlessly integrate powerful Compose Multiplatform navigation and robust ScreenModel ViewModels, ensuring unified app experiences across Android, iOS, and Desktop platforms with precision and efficiency.",
            link = "https://medium.com/@italord.melo/voyager-compose-multiplatform-navigation-and-viewmodels-screenmodel-b36693484d98",
            date = "Apr 14, 2024"
        ),
        Article(
            image = Res.drawable.leak_canary,
            title = "Leak Canary : Find and handle memory leaks on Android Development",
            description = "Identify and manage memory leaks in Android development with expert techniques for robust app performance, stability, and enhanced user experience.",
            link = "https://medium.com/@italord.melo/leak-canary-find-and-handle-memory-leaks-on-android-development-25c24a3fb930",
            date = "Feb 14, 2024"
        ),
        Article(
            image = Res.drawable.chat,
            title = "Creating a realtime chat app with Compose Multiplatform and Firestore Database",
            description = "Learn how to build a realtime chat app using Jetpack Compose Multiplatform and Firebase Database.",
            link = "https://medium.com/@italord.melo/creating-a-realtime-chat-app-with-compose-multiplatform-and-firestore-e7afafc0be57",
            date = "Nov 21, 2024"
        ),
        Article(
            image = Res.drawable.medium_compose_web,
            title = "Compose Multiplatform for Web: My Experience so far",
            description = "On this article, i will talk about the state of Compose Multiplatform for Web, and my experience building my new home page",
            link = "https://medium.com/@italord.melo/compose-multiplatform-for-web-my-experience-so-far-5b6b354e02d0",
            date = "Jan 6, 2025"
        ),
        Article(
            image = Res.drawable.compose_inside_swift,
            title = "Using Composables inside SwiftUI with Compose Multiplatform",
            description = "Larn with the help of Kotlin/Native, make compose UI code compile into an XCFramework and integrated into iOS projects.",
            link = "https://medium.com/@italord.melo/using-composables-inside-swiftui-using-compose-multiplatform-d82748e56b93",
            date = "Apr 4, 2025"
        )
    )
}