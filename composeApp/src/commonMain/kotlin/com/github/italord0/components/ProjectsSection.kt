package com.github.italord0.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.data.Projects
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsSection() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Projects", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                fontSize = 20.sp
            )
        )
        Text(
            text = "Each project is a unique piece of development!", style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                fontSize = 18.sp
            )
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(64.dp, Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(64.dp)
        ) {
            Projects.data.forEach { project ->
                ProjectCell(project) {
                    uriHandler.openUri(it)
                }
            }
        }
    }

}