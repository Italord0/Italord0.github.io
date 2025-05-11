package com.github.italord0.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
        ) {
            items.forEach {
                LinkButton(
                    text = it,
                    textSize = 24.sp,
                    fontFamily = FontFamily(Font(resource = Res.font.spacemono_bold))
                ) {
                    onRouteClicked(it)
                }
            }
        }
        Divider(modifier = Modifier.fillMaxWidth().height(1.dp))
    }
}