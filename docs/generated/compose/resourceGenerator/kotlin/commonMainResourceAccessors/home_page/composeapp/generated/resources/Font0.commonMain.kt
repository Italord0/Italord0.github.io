@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package home_page.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainFont0 {
  public val spacemono_bold: FontResource by 
      lazy { init_spacemono_bold() }

  public val spacemono_bolditalic: FontResource by 
      lazy { init_spacemono_bolditalic() }

  public val spacemono_italic: FontResource by 
      lazy { init_spacemono_italic() }

  public val spacemono_regular: FontResource by 
      lazy { init_spacemono_regular() }
}

@InternalResourceApi
internal fun _collectCommonMainFont0Resources(map: MutableMap<String, FontResource>) {
  map.put("spacemono_bold", CommonMainFont0.spacemono_bold)
  map.put("spacemono_bolditalic", CommonMainFont0.spacemono_bolditalic)
  map.put("spacemono_italic", CommonMainFont0.spacemono_italic)
  map.put("spacemono_regular", CommonMainFont0.spacemono_regular)
}

internal val Res.font.spacemono_bold: FontResource
  get() = CommonMainFont0.spacemono_bold

private fun init_spacemono_bold(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:spacemono_bold",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/home_page.composeapp.generated.resources/font/spacemono_bold.ttf", -1, -1),
    )
)

internal val Res.font.spacemono_bolditalic: FontResource
  get() = CommonMainFont0.spacemono_bolditalic

private fun init_spacemono_bolditalic(): FontResource =
    org.jetbrains.compose.resources.FontResource(
  "font:spacemono_bolditalic",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/home_page.composeapp.generated.resources/font/spacemono_bolditalic.ttf", -1, -1),
    )
)

internal val Res.font.spacemono_italic: FontResource
  get() = CommonMainFont0.spacemono_italic

private fun init_spacemono_italic(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:spacemono_italic",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/home_page.composeapp.generated.resources/font/spacemono_italic.ttf", -1, -1),
    )
)

internal val Res.font.spacemono_regular: FontResource
  get() = CommonMainFont0.spacemono_regular

private fun init_spacemono_regular(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:spacemono_regular",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/home_page.composeapp.generated.resources/font/spacemono_regular.ttf", -1, -1),
    )
)
