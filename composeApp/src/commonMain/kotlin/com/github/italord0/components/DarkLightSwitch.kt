package com.github.italord0.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.italord0.util.AppTheme
import com.github.italord0.util.LocalAppTheme
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.moon
import home_page.composeapp.generated.resources.sun
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DarkLightSwitch(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val switchWidth = 80.dp
    val switchHeight = 40.dp
    val padding = 4.dp
    val circleSize = switchHeight - padding * 2

    val theme = LocalAppTheme.current

    val circleOffset by animateDpAsState(
        targetValue = if (isDarkMode) switchWidth - circleSize - padding - 25.dp else padding - circleSize + 10.dp
    )
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .width(switchWidth)
            .height(switchHeight)
            .background(
                color = if (isDarkMode) theme.colors.onBackground else Color.LightGray,
                shape = RoundedCornerShape(50)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) { onToggle(!isDarkMode) }
            .pointerHoverIcon(PointerIcon.Hand),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .offset(x = circleOffset)
                .size(circleSize)
                .align(Alignment.Center),
            elevation = 15.dp,
            shape = CircleShape
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Crop,
                    painter = if (isDarkMode) painterResource(Res.drawable.moon) else painterResource(
                        Res.drawable.sun
                    ),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun DarkLightSwitchPreview() {
    AppTheme {
        val systemDark = isSystemInDarkTheme()
        var isDarkMode by remember { mutableStateOf(systemDark) }
        DarkLightSwitch(isDarkMode = true, onToggle = { isDarkMode = !isDarkMode })
    }
}
