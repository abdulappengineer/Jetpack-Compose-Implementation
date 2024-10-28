package com.soha.infotech.jetpackcomposeimplementation.user_list_user_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Step3: Design User list item screen
 */

@Composable
fun UserListItem(user: User, onClick: (user: User) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .clickable { onClick(user) }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                //imageVector = Icons.Filled.HeartBroken,
                imageVector = Icons.Filled.HeartBroken,
                contentDescription = "User",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )

            Spacer(modifier = Modifier.padding(4.dp))
            //Spacer(modifier = Modifier.width(4.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.bodyLarge,
                    // modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color.Gray)
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                )
                Text(
                    text = user.occupation,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}