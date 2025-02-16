package com.github.italord0.screens

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
import com.github.italord0.components.ArticleCell
import com.github.italord0.data.Articles
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BlogScreen() {
    val uriHandler = LocalUriHandler.current
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(20.dp),
            text = "Check out my latest articles!",
            style = TextStyle(
                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                fontSize = 32.sp
            )
        )
        FlowRow(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.Start),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            Articles.data.reversed().forEach { article ->
                ArticleCell(article) { uriHandler.openUri(it) }
            }
        }
    }
}