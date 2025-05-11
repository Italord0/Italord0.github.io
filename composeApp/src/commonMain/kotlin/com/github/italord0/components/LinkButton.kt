package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.extension.onHover
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.github
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LinkButton(
    text: String = "",
    textSize: TextUnit = 18.sp,
    icon: DrawableResource? = null,
    iconSize: Dp = 24.dp,
    fontFamily: FontFamily = FontFamily(Font(Res.font.spacemono_regular)),
    onClick: () -> Unit = {}
) {
    var isHovered by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = { onClick() }
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .onHover { isHovered = it },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text, style = TextStyle(
                fontFamily = fontFamily,
                fontSize = textSize,
                color = if (isHovered) Color.Red else Color.Black
            )
        )
        icon?.let {
            if (text.isNotEmpty()) {
                Spacer(modifier = Modifier.width(8.dp))
            }
            Image(
                modifier = Modifier.size(iconSize),
                painter = painterResource(it),
                colorFilter = ColorFilter.tint(if (isHovered) Color.Red else Color.Black),
                contentDescription = null
            )
        }
    }
}

@Composable
@Preview
private fun LinkButtonPreview() {
    LinkButton("Link without icon") {

    }
}

@Composable
@Preview
private fun LinkButtonIconPreview() {
    LinkButton(icon = Res.drawable.github, text = "Link with icon") {

    }
}

@Composable
@Preview
private fun LinkButtonOnlyIconPreview() {
    LinkButton(icon = Res.drawable.github) {

    }
}