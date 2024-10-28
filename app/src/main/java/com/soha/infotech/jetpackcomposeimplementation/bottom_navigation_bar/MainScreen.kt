package com.soha.infotech.jetpackcomposeimplementation.bottom_navigation_bar


import com.soha.infotech.jetpackcomposeimplementation.R

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .background(colorResource(id = R.color.teal_200))
            ) {
                Navigation(navController = navController)
            }
        }
    )
}
