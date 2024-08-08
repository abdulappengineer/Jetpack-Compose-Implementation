package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soha.infotech.jetpackcomposeimplementation.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // your click code here
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "Simple Button")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithGrayColor(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Gray, // Background color
            contentColor = Color.White // Text color
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {
        Text(text = "Button with gray color", modifier = Modifier.padding(20.dp)) // Inner padding)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithTwoTextView(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "Click")
        Text(text = "Here", modifier = Modifier.padding(start = 10.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithIcon(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        }, modifier = modifier
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Cart button icon",
            modifier = modifier.size(20.dp)
        )
        Text(
            text = "Add to cart",
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithShape(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        },
        // shape = RectangleShape,
        // shape = RoundedCornerShape(20.dp),
        shape = CutCornerShape(5.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        // Text(text = "Rectangle shape")
        // Text(text = "Rounded shape")
        Text(text = "Cut corner shape")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithBorder(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        },
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.LightGray,
            contentColor = Color.White,
        )

    ) {
        Text(text = "Button with border")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonWithElevation(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // write your click code
        },
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp


        )
    ) {
        Text(text = "Button with elevation")
    }
}