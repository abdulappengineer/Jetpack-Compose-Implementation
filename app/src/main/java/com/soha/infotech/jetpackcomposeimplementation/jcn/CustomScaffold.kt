package com.soha.infotech.jetpackcomposeimplementation.jcn

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold(
    title: String,
    onNavigationClick: () -> Unit = {},
    showBottomBar: Boolean = true,
    floatingActionButton: @Composable () -> Unit = {},
    topBarColor: Color = MaterialTheme.colorScheme.primary,
    titleColor: Color = Color.Black,
    tintColor: Color = Color.Black,
    navigationIcon: @Composable (() -> Unit)? = {
        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = tintColor)
    },
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title, color = titleColor) },
                navigationIcon = {
                    if (navigationIcon != null) {
                        IconButton(onClick = onNavigationClick) {
                            navigationIcon()
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarColor // Set the background color
                )
            )
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar {
                    Text(text = "Bottom Bar Content")
                }
            }
        },
        floatingActionButton = floatingActionButton,
        content = { paddingValues ->
            // Pass the padding values to the content
            content(paddingValues)
        }
    )
}

