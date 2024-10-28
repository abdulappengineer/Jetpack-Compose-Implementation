package com.soha.infotech.jetpackcomposeimplementation.practice

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun TextStyleDemo(modifier: Modifier = Modifier) {
    Text(
        "Hello World",
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            color = Color.Blue,
            letterSpacing = 0.5.em,
            // background = Color.Cyan,
            textDecoration = TextDecoration.Underline,
            shadow = Shadow(
                color = Color.Blue,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )
        )
    )
}