package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleText(modifier: Modifier = Modifier) {
    Text(
        text = "Jetpack Compose Text".repeat(50),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Color.Blue,
        fontSize = 24.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
    )
}