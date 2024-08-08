package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleRow(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Row Text 1", modifier = Modifier.background(Color.Red))
        Text(text = "Row Text 2", modifier = Modifier.background(Color.Green))
        Text(text = "Row Text 3", modifier = Modifier.background(Color.Blue))
    }
}