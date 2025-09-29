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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.util.LocalAppTheme
import home_page.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

const val EMAIL_ADDRESS = "contact@italomelo.dev"

@Composable
fun ContactSection() {
    val uriHandler = LocalUriHandler.current
    val theme = LocalAppTheme.current
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Contact me", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                fontSize = 24.sp,
                color = theme.colors.text
            )
        )
        Text(
            text = "Don't be shy! Hit me up! \uD83D\uDC47", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                fontSize = 18.sp,
                color = theme.colors.text
            )
        )
    }
    Spacer(modifier = Modifier.height(32.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(Res.drawable.envelope),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = theme.colors.text)
        )
        Spacer(modifier = Modifier.width(32.dp))
        Column {
            Text(
                text = "Mail", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 18.sp,
                    color = theme.colors.text
                )
            )
            val interactionSource = remember { MutableInteractionSource() }
            Text(
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = { uriHandler.openUri("mailto:$EMAIL_ADDRESS") }
                ).pointerHoverIcon(PointerIcon.Hand),
                text = EMAIL_ADDRESS, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 18.sp,
                    color = theme.colors.text
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(32.dp))
}