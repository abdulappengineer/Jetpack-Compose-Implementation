package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.R

/**
 * Note:  Most important for interview
 */

@Preview(showSystemUi = true)
@Composable
fun SimpleLazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.padding(40.dp)
    ) {
        // Add a single item
        item {
            Text(
                "Header",
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        }

        // Add 3 items
        items(3) { index ->
            Text(
                "First List Items: $index",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        }

        // Add 2 items
        items(2) { index ->
            Text(
                "Second List Items: $index",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        }

        // Add another single item
        item {
            Text(
                "Footer",
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SimpleList(modifier: Modifier = Modifier) {
    val countryList = mutableListOf(
        "India",
        "Pakistan",
        "China",
        "United States",
        "Canada",
        "Brazil",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "Russia",
        "United Kingdom",
        "South Africa",
        "Mexico",
        "Italy",
        "Spain",
        "South Korea",
        "Argentina",
        "Saudi Arabia",
        "Nigeria"
    )

    val listModifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(40.dp)

    val textStyle = TextStyle(
        fontSize = 20.sp,
        color = Color.White
    )

    LazyColumn(
        modifier = listModifier
    ) {
        items(countryList) { country ->
            Text(
                text = country, style = textStyle
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Green)
        }
    }
}

data class FruitModel(val name: String, val image: Int)

private val fruitsList = mutableListOf(
    FruitModel("Apple", R.drawable.ic_profile),
    FruitModel("Orange", R.drawable.ic_book),
    FruitModel("Banana", R.drawable.ic_home),
    FruitModel("Strawberry", R.drawable.ic_movie),
    FruitModel("Mango", R.drawable.ic_music),
    FruitModel("Grapes", R.drawable.ic_profile),
    FruitModel("Pineapple", R.drawable.ic_book),
    FruitModel("Watermelon", R.drawable.ic_home),
    FruitModel("Papaya", R.drawable.ic_movie),
    FruitModel("Blueberry", R.drawable.ic_music),
    FruitModel("Kiwi", R.drawable.ic_profile),
    FruitModel("Peach", R.drawable.ic_book),
    FruitModel("Pear", R.drawable.ic_home),
    FruitModel("Plum", R.drawable.ic_movie),
    FruitModel("Cherry", R.drawable.ic_music),
    FruitModel("Coconut", R.drawable.ic_profile),
    FruitModel("Pomegranate", R.drawable.ic_book),
    FruitModel("Lemon", R.drawable.ic_home),
    FruitModel("Guava", R.drawable.ic_movie),
    FruitModel("Lychee", R.drawable.ic_music)
)

@Composable
fun ListRow(model: FruitModel) {
    Row(
        modifier = Modifier
            // .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun CustomList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
            HorizontalDivider(thickness = 1.dp, color = Color.Green)
        }

    }
}

