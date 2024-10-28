package com.soha.infotech.jetpackcomposeimplementation.user_list_user_item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.soha.infotech.jetpackcomposeimplementation.R

@Composable
fun UserListScreen(userList: List<User>, onCLick: (user: User) -> Unit) {
    Column {
        Text(
            text = "User App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleLarge,
            fontFamily = FontFamily(Font(R.font.montserrat_regular))
        )
        UserList(userList = userList, onCLick)
    }
}