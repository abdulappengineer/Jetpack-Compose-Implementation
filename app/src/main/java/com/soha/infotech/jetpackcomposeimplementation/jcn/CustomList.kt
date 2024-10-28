package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpackcomposeimplementation.R

data class User(val name: String, val age: Int, val image: Int)

val userList = mutableListOf(
    User("Profile Description", 31, R.drawable.ic_profile),
    User("Home Description", 31, R.drawable.ic_home),
    User("Music Description", 31, R.drawable.ic_music),
    User("Movie Description", 31, R.drawable.ic_movie),
    User("Book Description", 31, R.drawable.ic_book),

    User("Profile Description", 31, R.drawable.ic_profile),
    User("Home Description", 31, R.drawable.ic_home),
    User("Music Description", 31, R.drawable.ic_music),
    User("Movie Description", 31, R.drawable.ic_movie),
    User("Book Description", 31, R.drawable.ic_book),

    User("Profile Description", 31, R.drawable.ic_profile),
    User("Home Description", 31, R.drawable.ic_home),
    User("Music Description", 31, R.drawable.ic_music),
    User("Movie Description", 31, R.drawable.ic_movie),
    User("Book Description", 31, R.drawable.ic_book),

    User("Profile Description", 31, R.drawable.ic_profile),
    User("Home Description", 31, R.drawable.ic_home),
    User("Music Description", 31, R.drawable.ic_music),
    User("Movie Description", 31, R.drawable.ic_movie),
    User("Book Description", 31, R.drawable.ic_book),
)

@Composable
fun ListRow(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = user.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(80.dp),
            colorFilter = ColorFilter.tint(Color.Red)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = user.name,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = user.age.toString(),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DisplayLis(userList: List<User>) {
    LazyColumn {
        items(userList) { user ->
            ListRow(user)
            HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    DisplayLis(userList)
}