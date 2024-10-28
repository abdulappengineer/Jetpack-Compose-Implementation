package com.soha.infotech.jetpackcomposeimplementation.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun ModifiersDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Text(
            "Text with green background color",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.background(Color.Green)
        )*/

        /**
         * Padding
         * Jetpack compose doesn't have a modifier for margin.
         * We should use the padding modifier for both padding and margin.
         */
        /* Text(
             "Padding and margin!",
             fontSize = 24.sp,
             fontWeight = FontWeight.Bold,
             modifier = Modifier
                 .background(Color.Red) // Color for margin
                 .padding(32.dp) // Outer padding (margin)
                 .background(Color.Magenta) // Color for padding
                 .padding(32.dp) // Inner padding
                 .background(Color.Yellow) // Color for text content
         )*/

        /**
         * Width and Height
         */
        Text(
            "Width and Height!",
            modifier = Modifier
                .background(Color.Yellow)
                /*.width(200.dp)
                .height(300.dp)*/
                .size(width = 200.dp, height = 300.dp)
        )

    }
}