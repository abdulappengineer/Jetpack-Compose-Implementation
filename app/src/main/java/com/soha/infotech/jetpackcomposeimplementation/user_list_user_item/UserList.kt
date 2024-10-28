package com.soha.infotech.jetpackcomposeimplementation.user_list_user_item

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserList(userList: List<User>, onClick: (user: User) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(bottom = 60.dp) //  padding for the bottom list item
    ) {

        items(userList) {
            UserListItem(user = it, onClick)
        }
    }
}