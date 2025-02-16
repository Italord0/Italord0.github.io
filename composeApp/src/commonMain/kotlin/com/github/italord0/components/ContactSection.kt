package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home_page.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection() {
    val uriHandler = LocalUriHandler.current
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Contact me", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                fontSize = 24.sp
            )
        )
        Text(
            text = "Don't be shy! Hit me up! \uD83D\uDC47", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(Res.drawable.envelope),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(32.dp))
            Column {
                Text(
                    text = "Mail", style = TextStyle(
                        fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                        fontSize = 18.sp
                    )
                )
                val interactionSource = remember { MutableInteractionSource() }
                Text(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource,
                        onClick = { uriHandler.openUri("mailto:italord.melo@gmail.com") }
                    ).pointerHoverIcon(PointerIcon.Hand),
                    text = "italord.melo@gmail.com", style = TextStyle(
                        fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                        fontSize = 18.sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Text(
                text = "Made with ", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 14.sp
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
                    fontSize = 14.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Copyright © 2025. All rights are reserved.", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                fontSize = 18.sp
            ),
            textAlign = TextAlign.Center
        )
    }
}