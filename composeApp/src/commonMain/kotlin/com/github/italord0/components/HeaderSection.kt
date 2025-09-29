package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.util.LocalAppTheme
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.github
import home_page.composeapp.generated.resources.java
import home_page.composeapp.generated.resources.kotlin
import home_page.composeapp.generated.resources.linkedin
import home_page.composeapp.generated.resources.me
import home_page.composeapp.generated.resources.medium
import home_page.composeapp.generated.resources.react
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import home_page.composeapp.generated.resources.swift
import home_page.composeapp.generated.resources.twitter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HeaderSection() {
    val uriHandler = LocalUriHandler.current
    val theme = LocalAppTheme.current
    Column {
        FlowRow(
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                SelectionContainer {
                    Column {
                        Text(
                            text = "Italo Melo",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                                fontSize = 32.sp,
                                color = theme.colors.text
                            )
                        )
                        Text(
                            text = "Hi! I'm a Mobile Developer \nbased in Recife, Brazil.",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                                fontSize = 20.sp,
                                color = theme.colors.text
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    val links: List<Pair<DrawableResource, String>> = listOf(
                        Pair(Res.drawable.linkedin, "https://www.linkedin.com/in/italocmelo"),
                        Pair(Res.drawable.github, "https://github.com/italord0/"),
                        Pair(Res.drawable.twitter, "https://x.com/olemolati/"),
                        Pair(Res.drawable.medium, "https://medium.com/@italord.melo")
                    )
                    links.forEach {
                        LinkButton(
                            icon = it.first,
                            iconSize = 32.dp
                        ) { uriHandler.openUri(it.second) }
                    }
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            Image(
                contentDescription = null,
                modifier = Modifier.size(150.dp).clip(CircleShape),
                painter = painterResource(Res.drawable.me)
            )
        }
        Spacer(modifier = Modifier.height(42.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(
                16.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                text = "Tech Stack", style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 20.sp,
                    color = theme.colors.text
                )
            )
            val stacks = listOf(
                Res.drawable.kotlin,
                Res.drawable.swift,
                Res.drawable.java,
                Res.drawable.react
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                stacks.forEach {
                    Image(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(it),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(color = theme.colors.text)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HeaderSectionPreview() {
    Surface {
        HeaderSection()
    }
}