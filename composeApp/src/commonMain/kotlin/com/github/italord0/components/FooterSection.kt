package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.util.LocalAppTheme
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.heart
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun FooterSection() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
        val theme = LocalAppTheme.current
        Row {
            Text(
                text = "Made with ", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 14.sp,
                    color = theme.colors.text
                )
            )
            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(Res.drawable.heart),
                contentDescription = null
            )
            Text(
                text = " using Compose Multiplatform", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 14.sp,
                    color = theme.colors.text
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Copyright © 2025. All rights are reserved.", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                fontSize = 18.sp,
                color = theme.colors.text
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}