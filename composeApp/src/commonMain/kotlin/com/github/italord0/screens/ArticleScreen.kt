package com.github.italord0.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.github.italord0.data.Article
import com.mikepenz.markdown.coil3.Coil3ImageTransformerImpl
import com.mikepenz.markdown.compose.components.markdownComponents
import com.mikepenz.markdown.compose.elements.MarkdownHighlightedCodeBlock
import com.mikepenz.markdown.compose.elements.MarkdownHighlightedCodeFence
import com.mikepenz.markdown.m2.Markdown
import com.mikepenz.markdown.m2.markdownTypography
import com.mikepenz.markdown.model.rememberMarkdownState
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.SyntaxThemes
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.spacemono_bold
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArticleScreen(
    article: Article
) {

    val baseTextStyle = TextStyle(
        fontFamily = FontFamily(Font(Res.font.spacemono_bold))
    )

    val markdownTypography = markdownTypography(
        h1 = baseTextStyle.copy(fontSize = 28.sp),
        h2 = baseTextStyle.copy(fontSize = 24.sp),
        h3 = baseTextStyle.copy(fontSize = 20.sp),
        h4 = baseTextStyle.copy(fontSize = 18.sp),
        h5 = baseTextStyle.copy(fontSize = 16.sp),
        h6 = baseTextStyle.copy(fontSize = 14.sp),
        paragraph = baseTextStyle.copy(fontSize = 16.sp),
        list = baseTextStyle.copy(fontSize = 14.sp),
        code = TextStyle(
            fontFamily = FontFamily.Monospace
        ),
        quote = baseTextStyle.copy(fontSize = 14.sp)
    )

    val highlightsBuilder = Highlights.Builder().theme(SyntaxThemes.atom(darkMode = false))


    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = article.title,
            style = baseTextStyle.copy(fontSize = 28.sp)
        )
        Spacer(Modifier.height(20.dp))
        Image(
            modifier = Modifier.widthIn(max = 480.dp),
            alignment = Alignment.Center,
            contentDescription = null,
            painter = painterResource(article.image),
            contentScale = ContentScale.FillWidth
        )
        SelectionContainer {
            Markdown(
                modifier = Modifier.fillMaxWidth(),
                markdownState = rememberMarkdownState {
                    Res.readBytes(article.markdownFileString).decodeToString()
                },
                typography = markdownTypography,
                imageTransformer = Coil3ImageTransformerImpl,
                components = markdownComponents(
                    codeBlock = {
                        MarkdownHighlightedCodeBlock(
                            content = it.content,
                            node = it.node,
                            highlights = highlightsBuilder
                        )
                    },
                    codeFence = {
                        MarkdownHighlightedCodeFence(
                            content = it.content,
                            node = it.node,
                            highlights = highlightsBuilder
                        )
                    }
                )
            )
        }
    }
}