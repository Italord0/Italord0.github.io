package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.data.Platform
import com.github.italord0.data.Project
import home_page.composeapp.generated.resources.*
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.github
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProjectCell(project: Project, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier.width(350.dp).height(450.dp),
        shape = RoundedCornerShape(60.dp),
        elevation = 15.dp
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                painter = painterResource(project.image)
            )
            Text(
                text = project.name, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                if (project.platforms.contains(Platform.ANDROID)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.android),
                        contentDescription = null
                    )
                }
                if (project.platforms.contains(Platform.IOS)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.apple),
                        contentDescription = null
                    )
                }
                if (project.platforms.contains(Platform.DESKTOP)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.desktop),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.height(160.dp).padding(16.dp),
                text = project.description, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 18.sp
                )
            )
            var codeActive by remember { mutableStateOf(false) }
            var demoActive by remember { mutableStateOf(false) }
            val interactionSource = remember { MutableInteractionSource() }
            project.prodLink?.let {
                Row(
                    modifier = Modifier.onPointerEvent(PointerEventType.Enter) {
                        demoActive = true
                    }.onPointerEvent(PointerEventType.Exit) { demoActive = false }.clickable(
                        indication = null,
                        interactionSource = interactionSource,
                        onClick = { onClick(project.prodLink) }
                    ).pointerHoverIcon(PointerIcon.Hand),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Demo", style = TextStyle(
                            fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                            fontSize = 18.sp,
                            color = if (demoActive) Color.Red else Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(Res.drawable.desktop),
                        colorFilter = ColorFilter.tint(if (demoActive) Color.Red else Color.Black),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.onPointerEvent(PointerEventType.Enter) {
                    codeActive = true
                }.onPointerEvent(PointerEventType.Exit) { codeActive = false }.clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = { onClick(project.codeLink) }
                ).pointerHoverIcon(PointerIcon.Hand),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Code", style = TextStyle(
                        fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                        fontSize = 18.sp,
                        color = if (codeActive) Color.Red else Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.github),
                    colorFilter = ColorFilter.tint(if (codeActive) Color.Red else Color.Black),
                    contentDescription = null
                )
            }
        }
    }
}