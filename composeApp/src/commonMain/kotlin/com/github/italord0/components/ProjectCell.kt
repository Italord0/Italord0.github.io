package com.github.italord0.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.italord0.data.Platform
import com.github.italord0.data.Project
import home_page.composeapp.generated.resources.Res
import home_page.composeapp.generated.resources.android
import home_page.composeapp.generated.resources.apple
import home_page.composeapp.generated.resources.desktop
import home_page.composeapp.generated.resources.flappy
import home_page.composeapp.generated.resources.github
import home_page.composeapp.generated.resources.spacemono_bold
import home_page.composeapp.generated.resources.spacemono_regular
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProjectCell(project: Project, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier.width(350.dp).height(450.dp),
        shape = RoundedCornerShape(60.dp),
        elevation = 15.dp
    ) {
        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                painter = painterResource(project.image)
            )
            Text(
                text = project.name, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_bold)),
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                if (project.platforms.contains(Platform.ANDROID)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.android),
                        contentDescription = null
                    )
                }
                if (project.platforms.contains(Platform.IOS)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.apple),
                        contentDescription = null
                    )
                }
                if (project.platforms.contains(Platform.DESKTOP)) {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(Res.drawable.desktop),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.height(160.dp).padding(16.dp),
                text = project.description, style = TextStyle(
                    fontFamily = FontFamily(Font(Res.font.spacemono_regular)),
                    fontSize = 18.sp
                )
            )
            project.webLink?.let {
                LinkButton(icon = Res.drawable.desktop, text = "Demo") {
                    onClick(project.webLink)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            LinkButton(icon = Res.drawable.github, text = "Code") { onClick(project.codeLink) }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

@Composable
@Preview
fun ProjectCellPreview() {
    ProjectCell(
        Project(
            image = Res.drawable.flappy,
            "Flappy Clone",
            "A clone of the popular game Flappy Bird using LibGDX game framework",
            listOf(
                Platform.ANDROID,
                Platform.DESKTOP
            ),
            "",
            webLink = ""
        )
    ) {}
}