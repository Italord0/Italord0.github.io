package com.github.italord0.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import org.jetbrains.compose.resources.Font

@Composable
fun TopBar(
    onRouteClicked: (String) -> Unit
) {

    val items = listOf("Home", "Blog")

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            items.forEach {
                Text(
                    modifier = Modifier
                        .clickable { onRouteClicked(it) }
                        .padding(8.dp),
                    text = it,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(resource = Res.font.spacemono_bold))
                    ),
                    fontSize = 24.sp
                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().height(2.dp).background(Color.LightGray)) { }
    }
}