package com.soha.infotech.jetpackcomposeimplementation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Composable
 * public fun Scaffold(
 *     modifier: Modifier = Modifier,
 *     topBar: @Composable () -> Unit = {},
 *     bottomBar: @Composable () -> Unit = {},
 *     snackbarHost: @Composable () -> Unit = {},
 *     floatingActionButton: @Composable () -> Unit = {},
 *     floatingActionButtonPosition: FabPosition = FabPosition. End,
 *     containerColor: Color = MaterialTheme. colorScheme. background,
 *     contentColor: Color = contentColorFor(containerColor),
 *     contentWindowInsets: WindowInsets = ScaffoldDefaults. contentWindowInsets,
 *     content: @Composable (PaddingValues) -> Unit
 * ): Unit
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScaffoldSample(modifier: Modifier = Modifier) {
    val context = LocalContext.current // Get the context

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    //Text(text = "Top App Bar")

                    Row() {
                        Text(
                            text = "Title 1",
                            fontSize = 30.sp,
                            color = Color.Red
                        )
                        Text(
                            text = "Title 2",
                            fontSize = 30.sp,
                            color = Color.White
                        )

                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                ),
                //composable function for leading icon
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "backIcon",
                            tint = Color.White
                        )
                    }
                }, // ends navigationIcon

            ) // ends TopAppBar
        }, // ends topBar

        // By default FabPosition will be End
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show()
                },
                // modifier = Modifier.padding(16.dp) // Add padding to avoid edge collision
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }, // ends floatingActionButton

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Gray,
                contentColor = Color.White
            ) {
                Text(text = "Bottom App Bar")
            }
        } // ends bottomBar

    ) {
        CustomListView(paddingValues = it)
    }
}

/**
 * ===========================================================================================
 */

// BottomNavigation
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScaffoldWithTopBar(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableStateOf(0) }

    // https://www.jetpackcompose.net/scaffold

    // https://bootcamp.uxdesign.cc/navigation-bar-with-jetpack-compose-32b052824b7d

    // https://scoder17.hashnode.dev/bottom-navigation-bar-in-jetpack-compose

    // https://saurabhjadhavblogs.com/jetpack-compose-bottom-navigation-nested-navigation-solved

}