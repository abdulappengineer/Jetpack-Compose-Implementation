package com.soha.infotech.jetpackcomposeimplementation.practice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.R

@Preview(showSystemUi = true)
@Composable
fun ButtonDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // your onclick code here
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            /* Text(
                 "Click",
                 color = Color.Magenta,
                 fontSize = 18.sp
             )
             Spacer(modifier = Modifier.width(20.dp))
             Text(
                 "Here!",
                 color = Color.Green,
                 fontSize = 18.sp
             )*/

            // Button with icon
            Image(
                painter = painterResource(R.drawable.ic_home),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(20.dp)
            )
            Text(
                "Ad to cart!",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonWithShape(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // your onclick code
            },
            shape = RectangleShape
        ) {
            Text(
                "Rectangle Shape"
            )
        }

        Button(
            onClick = {
                // your onclick code
            },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                "Round corner shape"
            )
        }

        Button(
            onClick = {
                // your onclick code
            },
            shape = CutCornerShape(10)
        ) {
            Text(
                "Cut corner shape"
            )
        }

        //Button With Border
        Button(
            onClick = {
                // your onclick code
            },
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
        ) {
            Text("Button with border")
        }

        // Button With elevation
        Button(
            onClick = {
                // your onclick code
            },
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                focusedElevation = 10.dp,
                hoveredElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text("Button with elevation")
        }

    }

}