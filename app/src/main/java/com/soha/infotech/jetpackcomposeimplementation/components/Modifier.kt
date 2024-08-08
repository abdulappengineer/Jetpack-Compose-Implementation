package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Background Color
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextWithBackground(modifier: Modifier = Modifier) {
    Text(
        text = "Text with green background color",
        modifier = Modifier.background(Color.Green)
    )
}

/**
 * Jetpack compose doesn't have a modifier for margin.
 * We should use the padding modifier for both padding and margin.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextWidthPadding(modifier: Modifier = Modifier) {
    Text(
        text = "Padding and Margin",
        modifier = Modifier
            .padding(32.dp) // outer padding / margin
            .background(Color.Green)
            .padding(16.dp) // inner padding
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WidthAndHeightModifier(modifier: Modifier = Modifier) {
    Text(
        text = "Width and Height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            /* .width(200.dp)
            .height(300.dp)*/
            .alpha(0.75f)//50% opacity
            .size(200.dp, 300.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeightModifier(modifier: Modifier = Modifier) {
    Row {
        Column(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Red)
        ) {
            Text(text = "Weight 1", color = Color.White)
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .height(200.dp)
                .background(Color.Green)
        ) {
            Text(text = "Weight 1", color = Color.White)
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .height(300.dp)
                .background(Color.Blue)
        ) {
            Text(text = "Weight 3", color = Color.White)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BorderModifier(modifier: Modifier = Modifier) {
    Text(
        text = "Text with red border",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp) // outer padding (margin)
            .background(Color.Yellow)
            .border(2.dp, Color.Red)
            .padding(20.dp) // inner padding

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BorderWithShape(modifier: Modifier = Modifier) {
    Text(
        text = "Text with rounder corner",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp) // outer padding (margin)
            .background(Color.Yellow)
            //.border(2.dp, SolidColor(Color.Red), RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(25.dp))
            .padding(20.dp) // inner padding

    )
}