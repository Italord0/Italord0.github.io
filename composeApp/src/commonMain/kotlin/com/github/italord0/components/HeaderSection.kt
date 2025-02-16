package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home_page.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HeaderSection() {
    val uriHandler = LocalUriHandler.current
    Column {
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Italo Melo",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                        fontSize = 32.sp
                    )
                )
                Text(
                    text = "Hi! I'm a Mobile Developer \nbased in Recife, Brazil.",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    val icons: List<Pair<DrawableResource, String>> = listOf(
                        Pair(Res.drawable.linkedin, "https://www.linkedin.com/in/italocmelo"),
                        Pair(Res.drawable.github, "https://github.com/italord0/"),
                        Pair(Res.drawable.twitter, "https://x.com/olemolati/"),
                        Pair(Res.drawable.medium, "https://medium.com/@italord.melo")
                    )
                    val interactionSource = remember { MutableInteractionSource() }
                    icons.forEach {
                        var rowActive by remember { mutableStateOf(false) }
                        Image(
                            contentDescription = null,
                            painter = painterResource(it.first),
                            modifier = Modifier.onPointerEvent(PointerEventType.Enter) {
                                rowActive = true
                            }.onPointerEvent(PointerEventType.Exit) { rowActive = false }.clickable(
                                indication = null,
                                interactionSource = interactionSource,
                                onClick = { uriHandler.openUri(it.second) }
                            ).pointerHoverIcon(PointerIcon.Hand).size(32.dp),
                            colorFilter = ColorFilter.tint(if (rowActive) Color.Red else Color.Black),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                contentDescription = null,
                modifier = Modifier.size(150.dp).clip(CircleShape),
                painter = painterResource(Res.drawable.me)
            )
        }
    }

    Spacer(modifier = Modifier.height(42.dp))
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            text = "Tech Stack", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                fontSize = 20.sp
            )
        )
        val stacks = listOf(
            Res.drawable.kotlin,
            Res.drawable.swift,
            Res.drawable.java,
            Res.drawable.react
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally)) {
            stacks.forEach {
                Image(modifier = Modifier.size(48.dp), painter = painterResource(it), contentDescription = null)
            }
        }
    }
}