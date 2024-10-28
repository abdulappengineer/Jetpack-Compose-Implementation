package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun TextWidthPadding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(color = Color.Cyan)
    ) {
        Text(
            "Padding and Margin!",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(40.dp) // Outer padding (margin)
                .background(color = Color.Green)
                .padding(20.dp) // Inner padding
                .background(Color.Magenta)
                .padding(10.dp) // Inner padding

        )
    }
}