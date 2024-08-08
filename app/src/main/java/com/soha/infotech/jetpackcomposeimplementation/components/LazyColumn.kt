package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListListScopeSample(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {

        // Add a single item
        item {
            Text(
                text = "Header",
                modifier = Modifier.padding(bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
        }

        // Add 3 items
        items(3) { index ->
            Text(
                text = "First List Items $index",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Add 2 items
        items(2) { index ->
            Text(
                text = "Second List Items $index",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Add another single item
        item {
            Text(
                text = "Footer",
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * ====================================================================================
 */

val countryList = mutableListOf(
    "India",
    "Pakistan",
    "USA",
    "UK",
    "Nepal",
    "Bhutan",
    "Indonesia",
    "Bangladesh",
    "England",
    "Africa",
    "Nederland"
)

val listModifier = Modifier
    .fillMaxSize()
    .background(Color.LightGray)
    .padding(16.dp)

val listTextStyle = TextStyle(
    fontSize = 20.sp,
    color = Color.White,
    fontStyle = FontStyle.Italic,
    fontFamily = FontFamily.Monospace,
    fontWeight = FontWeight.Medium
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleListView(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = listModifier,
    ) {
        items(countryList) { country ->
            Text(
                text = country,
                style = listTextStyle,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            // Horizontal line
            HorizontalDivider(thickness = 1.dp, color = Color.White)
        }
    }
}

/**
 * ====================================================================================
 */

// Create a data class
data class FruitModel(val name: String, val image: Int)

// Create a mutableList for add the list of fruit models
val fruitsList = mutableListOf(
    FruitModel("Apple", R.drawable.ic_launcher_background),
    FruitModel("Banana", R.drawable.ic_launcher_background),
    FruitModel("Papaya", R.drawable.ic_launcher_background),
    FruitModel("Mango", R.drawable.ic_launcher_background),
    FruitModel("Water Melon", R.drawable.ic_launcher_background),
    FruitModel("Grape", R.drawable.ic_launcher_background),
    FruitModel("Guava", R.drawable.ic_launcher_background),
    FruitModel("Pineapple", R.drawable.ic_launcher_background),
    FruitModel("Pomegranate", R.drawable.ic_launcher_background),
    FruitModel("Blackberry", R.drawable.ic_launcher_background),

    FruitModel("Apple", R.drawable.ic_launcher_background),
    FruitModel("Banana", R.drawable.ic_launcher_background),
    FruitModel("Papaya", R.drawable.ic_launcher_background),
    FruitModel("Mango", R.drawable.ic_launcher_background),
    FruitModel("Water Melon", R.drawable.ic_launcher_background),
    FruitModel("Grape", R.drawable.ic_launcher_background),
    FruitModel("Guava", R.drawable.ic_launcher_background),
    FruitModel("Pineapple", R.drawable.ic_launcher_background),
    FruitModel("Pomegranate", R.drawable.ic_launcher_background),
    FruitModel("Blackberry", R.drawable.ic_launcher_background),

    FruitModel("Apple", R.drawable.ic_launcher_background),
    FruitModel("Banana", R.drawable.ic_launcher_background),
    FruitModel("Papaya", R.drawable.ic_launcher_background),
    FruitModel("Mango", R.drawable.ic_launcher_background),
    FruitModel("Water Melon", R.drawable.ic_launcher_background),
    FruitModel("Grape", R.drawable.ic_launcher_background),
    FruitModel("Guava", R.drawable.ic_launcher_background),
    FruitModel("Pineapple", R.drawable.ic_launcher_background),
    FruitModel("Pomegranate", R.drawable.ic_launcher_background),
    FruitModel("Blackberry", R.drawable.ic_launcher_background),

    FruitModel("Apple", R.drawable.ic_launcher_background),
    FruitModel("Banana", R.drawable.ic_launcher_background),
    FruitModel("Papaya", R.drawable.ic_launcher_background),
    FruitModel("Mango", R.drawable.ic_launcher_background),
    FruitModel("Water Melon", R.drawable.ic_launcher_background),
    FruitModel("Grape", R.drawable.ic_launcher_background),
    FruitModel("Guava", R.drawable.ic_launcher_background),
    FruitModel("Pineapple", R.drawable.ic_launcher_background),
    FruitModel("Pomegranate", R.drawable.ic_launcher_background),
    FruitModel("Blackberry", R.drawable.ic_launcher_background),

    FruitModel("Apple", R.drawable.ic_launcher_background),
    FruitModel("Banana", R.drawable.ic_launcher_background),
    FruitModel("Papaya", R.drawable.ic_launcher_background),
    FruitModel("Mango", R.drawable.ic_launcher_background),
    FruitModel("Water Melon", R.drawable.ic_launcher_background),
    FruitModel("Grape", R.drawable.ic_launcher_background),
    FruitModel("Guava", R.drawable.ic_launcher_background),
    FruitModel("Pineapple", R.drawable.ic_launcher_background),
    FruitModel("Pomegranate", R.drawable.ic_launcher_background),
    FruitModel("Blackberry", R.drawable.ic_launcher_background),
)

// Create a row to display list items
@Composable
fun ListRow(fruitModel: FruitModel, onclick: (FruitModel) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onclick(fruitModel) } // implement list click
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = fruitModel.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = fruitModel.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}


@Composable
fun CustomListView(paddingValues: PaddingValues) {
    // state to clicked item
    var selectedFruit by remember { mutableStateOf<FruitModel?>(null) }

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White),
    ) {
        items(fruitsList) { item: FruitModel ->
            ListRow(fruitModel = item) {
                selectedFruit = it
            }
            // Horizontal line
            HorizontalDivider(thickness = 1.dp, color = Color.White)
        }
    }

    // Display details when an item is clicked
    selectedFruit?.let {
        AlertDialog(
            onDismissRequest = { selectedFruit = null },
            confirmButton = {
                TextButton(onClick = { selectedFruit = null }) {
                    Text(text = "Close")
                }
            },
            title = { Text(text = it.name) },
            text = { Text(text = "Details about: ${it.name}") }
        )
    }
}