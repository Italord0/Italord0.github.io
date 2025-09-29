package com.github.italord0.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.data.Article
import com.github.italord0.extension.onHover
import com.github.italord0.util.LocalAppTheme
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArticleCell(article: Article, onArticleClick: (String) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    var hovered by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (hovered) 1.1f else 1.0f, label = "scale")
    val theme = LocalAppTheme.current

    Card(
        modifier = Modifier
            .width(350.dp)
            .scale(scale)
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = { onArticleClick(article.link) }
            )
            .pointerHoverIcon(PointerIcon.Hand)
            .onHover { hovered = it },
        shape = RoundedCornerShape(30.dp),
        backgroundColor = theme.colors.background,
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.background(color = theme.colors.background)) {
            Image(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentDescription = null,
                painter = painterResource(article.image),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = article.title, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 18.sp,
                    color = theme.colors.text
                ),
                minLines = 3,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = article.description, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 14.sp,
                    color = theme.colors.text
                ),
                minLines = 7,
                maxLines = 7,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 16.dp),
                text = "Created on ${article.date}", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 12.sp,
                    color = theme.colors.text
                )
            )
        }
    }
}