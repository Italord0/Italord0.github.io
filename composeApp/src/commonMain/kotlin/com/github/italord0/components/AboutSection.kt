package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home_page.composeapp.generated.resources.*
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutSection() {
    FlowRow(
        Modifier.fillMaxWidth().padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(250.dp).clip(RoundedCornerShape(50.dp)),
            painter = painterResource(Res.drawable.coding),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(32.dp))
        Column(Modifier.width(800.dp)) {
            Text(
                text = "About me", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 20.sp
                )
            )
            Text(
                text = "As a Mobile Developer, I possess an arsenal of skills in Android, iOS, Compose Multiplatform and some React Native.\n" +
                        "\n" +
                        "My expertise lies in crafting dynamic, engaging interfaces through writing clean and optimized code and utilizing cutting-edge development tools and techniques.\n",
                style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 18.sp
                )
            )
        }
    }
}