package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soha.infotech.jetpackcomposeimplementation.R

@Preview(showSystemUi = true)
@Composable
fun BoxDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Red),
                modifier = Modifier.size(200.dp)
            )

            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(Color.Green)
            )
        }
    }


}