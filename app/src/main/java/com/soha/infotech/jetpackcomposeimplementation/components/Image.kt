package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soha.infotech.jetpackcomposeimplementation.R

/**
 * @Composable
 * fun Image(
 *     painter: Painter,
 *     contentDescription: String?,
 *     modifier: Modifier = Modifier,
 *     alignment: Alignment = Alignment.Center,
 *     contentScale: ContentScale = ContentScale.Fit,
 *     alpha: Float = DefaultAlpha,
 *     colorFilter: ColorFilter? = null
 * )
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Demo Image",
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CircleImageView(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Demo Image",
        contentScale = ContentScale.Crop,
        // colorFilter = ColorFilter.tint(Color.Gray), // Image ColorFilter (tint)
        modifier = Modifier
            .padding(16.dp)
            .size(120.dp)
            //.clip(CircleShape) // // clip to the circle shape
            //.border(5.dp, Color.Red, CircleShape)

            .clip(RoundedCornerShape(10)) // Round Corner Image
            .border(5.dp,Color.Red, RoundedCornerShape(10))
    )
}