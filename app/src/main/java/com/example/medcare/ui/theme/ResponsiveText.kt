package com.example.medcare.ui.theme

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Extension properties for sp values to scale responsively based on LocalResponsiveTextScale.
 */
val Int.responsiveSp: TextUnit
    @Composable get() = (this * LocalResponsiveTextScale.current).sp

val Float.responsiveSp: TextUnit
    @Composable get() = (this * LocalResponsiveTextScale.current).sp

val Double.responsiveSp: TextUnit
    @Composable get() = (this * LocalResponsiveTextScale.current).sp

val TextUnit.responsive: TextUnit
    @Composable get() = if (isSp) (value * LocalResponsiveTextScale.current).sp else this

/**
 * A Text composable that dynamically resizes font size if text exceeds container bounds or maxLines.
 */
@Composable
fun AutoResizedText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minFontSize: TextUnit = 10.sp,
    targetFontSize: TextUnit = style.fontSize
) {
    var resizedFontSize by remember(text, targetFontSize) {
        mutableStateOf(targetFontSize)
    }
    var shouldDraw by remember(text, targetFontSize) {
        mutableStateOf(false)
    }

    val updatedStyle = remember(style, resizedFontSize, color, fontStyle, fontWeight, fontFamily, letterSpacing, textDecoration, textAlign, lineHeight) {
        style.copy(
            color = if (color != Color.Unspecified) color else style.color,
            fontSize = if (resizedFontSize != TextUnit.Unspecified) resizedFontSize else style.fontSize,
            fontStyle = fontStyle ?: style.fontStyle,
            fontWeight = fontWeight ?: style.fontWeight,
            fontFamily = fontFamily ?: style.fontFamily,
            letterSpacing = if (letterSpacing != TextUnit.Unspecified) letterSpacing else style.letterSpacing,
            textDecoration = textDecoration ?: style.textDecoration,
            textAlign = textAlign ?: style.textAlign,
            lineHeight = if (lineHeight != TextUnit.Unspecified) lineHeight else style.lineHeight
        )
    }

    Text(
        text = text,
        modifier = modifier.drawWithContent {
            if (shouldDraw) {
                drawContent()
            }
        },
        style = updatedStyle,
        softWrap = softWrap,
        maxLines = maxLines,
        overflow = overflow,
        onTextLayout = { result ->
            if (result.hasVisualOverflow && resizedFontSize > minFontSize) {
                resizedFontSize = (resizedFontSize.value * 0.9f).sp
            } else {
                shouldDraw = true
            }
        }
    )
}
