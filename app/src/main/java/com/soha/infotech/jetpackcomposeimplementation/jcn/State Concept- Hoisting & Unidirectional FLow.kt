package com.soha.infotech.jetpackcomposeimplementation.jcn

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        NotificationCounter(count, { count++ })
    }

}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    //var count by remember { mutableIntStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You have sent $count notification", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                increment()
            }
        ) {
            Text(text = "Send Notification", fontSize = 24.sp)
        }
    }
}