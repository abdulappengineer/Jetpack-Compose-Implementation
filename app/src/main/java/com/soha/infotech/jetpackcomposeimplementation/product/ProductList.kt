package com.soha.infotech.jetpackcomposeimplementation.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.MainActivity
import com.soha.infotech.jetpackcomposeimplementation.R
import com.soha.infotech.jetpackcomposeimplementation.product.model.Product

@Composable
fun ProductList(list: List<Product>, paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier.padding(paddingValues)
            .background(Color.White)
    ) {
        items(list) { product ->
            ListRow(product, modifier = Modifier.padding(vertical = 8.dp))
            // Horizontal line
            HorizontalDivider(thickness = 1.dp, color = Color.White)
        }
    }
}

@Composable
fun ListRow(product: Product, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        // Center the Column vertically relative to the Image
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(5.dp)
        )

        Column(
        ) {
            Text(
                text = product.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = product.description,
                fontSize = 16.sp,
                maxLines = 1,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}