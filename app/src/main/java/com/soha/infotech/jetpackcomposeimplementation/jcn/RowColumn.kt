package com.soha.infotech.jetpackcomposeimplementation.jcn

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.R


@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun RowDemo(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "A", fontSize = 24.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "B", fontSize = 24.sp)
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun ColumnDemo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "A", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "B", fontSize = 24.sp)
    }
}

@Preview(heightDp = 500)
@Composable
fun PreviewItem(modifier: Modifier = Modifier) {
    /* Column {
         BlogCategory(R.drawable.ic_home, "Abdul Khalid", "Software Engineer")
         BlogCategory(R.drawable.ic_movie, "Deepa Singhal", "Software Engineer")
         BlogCategory(R.drawable.ic_book, "Razia Khan", "Software Engineer")
         BlogCategory(R.drawable.ic_music, "Sanavvar Khan", "Software Engineer")
         BlogCategory(R.drawable.ic_profile, "Deepu Verma", "Software Engineer")
     }*/

    /*Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        getCategoryList().map { item ->
            BlogCategory(item.img, item.title, item.subTitle)
        }
    }*/

    LazyColumn {
        items(getCategoryList()) { item ->
            BlogCategory(item.img, item.title, item.subTitle)
        }
    }

}

/**
 * 1 Image Left side and two text in right side
 */
// Custom Composable
@Composable
fun BlogCategory(imgId: Int, name: String, occupation: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)

    ) {

        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .weight(.2f),
                colorFilter = ColorFilter.tint(Color.Blue)
            )

            ItemDescription(name, occupation, Modifier.weight(.8f))
        }
    }
}

@Composable
fun ItemDescription(name: String, occupation: String, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = occupation,
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>(
        Category(R.drawable.ic_home, "Abdul Khalid", "Software Engineer"),
        Category(R.drawable.ic_movie, "Deepa Singhal", "Software Engineer"),
        Category(R.drawable.ic_book, "Razia Khan", "Software Engineer"),
        Category(R.drawable.ic_music, "Sanavvar Khan", "Software Engineer"),
        Category(R.drawable.ic_profile, "Deepu Verma", "Software Engineer"),

        Category(R.drawable.ic_home, "Abdul Khalid", "Software Engineer"),
        Category(R.drawable.ic_movie, "Deepa Singhal", "Software Engineer"),
        Category(R.drawable.ic_book, "Razia Khan", "Software Engineer"),
        Category(R.drawable.ic_music, "Sanavvar Khan", "Software Engineer"),
        Category(R.drawable.ic_profile, "Deepu Verma", "Software Engineer"),

        Category(R.drawable.ic_home, "Abdul Khalid", "Software Engineer"),
        Category(R.drawable.ic_movie, "Deepa Singhal", "Software Engineer"),
        Category(R.drawable.ic_book, "Razia Khan", "Software Engineer"),
        Category(R.drawable.ic_music, "Sanavvar Khan", "Software Engineer"),
        Category(R.drawable.ic_profile, "Deepu Verma", "Software Engineer"),

        Category(R.drawable.ic_home, "Abdul Khalid", "Software Engineer"),
        Category(R.drawable.ic_movie, "Deepa Singhal", "Software Engineer"),
        Category(R.drawable.ic_book, "Razia Khan", "Software Engineer"),
        Category(R.drawable.ic_music, "Sanavvar Khan", "Software Engineer"),
        Category(R.drawable.ic_profile, "Deepu Verma", "Software Engineer"),
    )
    return list
}
