# The Problem: Design System Duplication and Slower Development Cycles

In companies building products across Android and iOS, maintaining a consistent design system can quickly become complex and costly. Each platform typically has its own implementation of the same UI components, leading to:
- Duplication of effort across Android and iOS teams
- Inconsistent UI behavior and appearance across platforms
- Slower release cycles due to parallel work
- Higher maintenance costs and increased chance of regressions

When components must be updated or refined, teams must coordinate closely or risk diverging experiences. These inconsistencies are not only a design concern but can also impact usability, accessibility, and overall product quality.

# The Solution: Compose Multiplatform + SwiftUI Integration

JetBrains’ Compose Multiplatform allows UI code to be written once in Kotlin and reused across Android, iOS, desktop, and web. With the help of Kotlin/Native, this UI code can be compiled into an XCFramework and integrated into iOS projects. Developers can then use SwiftUI wrappers to expose these views in the iOS layer.

This approach offers several benefits:
- One source of truth for UI design and logic
- Faster implementation of new components across platform
- Lower maintenance cost and fewer bugs
- Improved collaboration between design and development teams

In this guide, we’ll walk through how to:
- Create a Compose Multiplatform module named `UI`
- Implement a composable component `AwesomeComposable`
- Export the UI code as an XCFramework
- Write a SwiftUI-compatible wrapper using `UIViewControllerRepresentable`
- Use it in a SwiftUI project

# Step 1: Setup Your `UI`  Compose Multiplatform Module

First, create a Kotlin Multiplatform module with Compose support.

`**build.gradle.kts**` **of the** `**ui**` **module:**

```
kotlin {
    androidTarget()

    val xcFramework = XCFramework()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { target ->
        target.binaries.framework {
            baseName = "UI"
            isStatic = true
            xcFramework.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "com.yourcompany.ui"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
```

# Step 2: Implement the Composable

In this example a a file called `AwesomeComposable.kt`  is created inside `ui/commonMain` .

```
package com.yourcompany.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AwesomeComposable() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Hello from Shared Compose UI!")
    }
}
```

Then create a simple `UIViewController`  to render this:

```
package com.yourcompany.ui

import androidx.compose.ui.window.ComposeUIViewController

fun AwesomeViewController() = ComposeUIViewController { AwesomeComposable() }
```

# Step 3: Build the XCFramework

From the root of your project, run:
```
./gradlew :ui:assembleXCFramework
```

The output will be available under:
```
ui/build/XCFrameworks/release/UI.xcframework
```

# Step 4: Create a Swift Wrapper inside your SwiftUI Project

Add `UI.xcframework`  to the "Frameworks, Libraries, and Embedded Content" section of your Swift project.

Now, let’s create a Swift wrapper:

```
import SwiftUI
//import your XCFramework module created by ComposeMultiplatform 
import UI

public struct AwesomeComposableView: UIViewControllerRepresentable {
    public init() {}

    public func makeUIViewController(context: Context) -> UIViewController {
        return UIAwesomeViewControllerKt.AwesomeViewController()
    }

    public func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
```

# Step 5: Use the UI in SwiftUI

Now you can use your `AwesomeComposableView`  inside any SwiftUI screen:

```
import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            AwesomeComposableView()
        }
    }
}
```

# Conclusion

By building an XCFramework from your Compose Multiplatform module, you can centralize your UI components and make them reusable across platforms. This reduces the cost of maintaining a consistent design system, eliminates redundant implementations, and significantly speeds up development. As teams grow and platforms multiply, this approach becomes essential for scaling efficiently while preserving quality.

