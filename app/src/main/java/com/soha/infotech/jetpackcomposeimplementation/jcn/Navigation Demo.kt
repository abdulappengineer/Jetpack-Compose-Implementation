package com.soha.infotech.jetpackcomposeimplementation.jcn

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun FirstScreen(navController: NavController) {
    // Prepare data and handle backstack entry
    val data = "Data come from First Screen "
    val msgFromNext =
        navController.currentBackStackEntry?.savedStateHandle?.get<String>("DATA_FROM_SECOND")

    // Reuse the CustomScaffold composable
    CustomScaffold(title = "First Screen",
        onNavigationClick = { /* Handle back navigation */ },
        false,
        topBarColor = Color.LightGray,
        titleColor = Color.White,
        tintColor = Color.White,
        navigationIcon = {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White)
        }) { paddingValues ->
        // All screen content inside the scaffold
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navController.navigate(RouteDestination.Second.createRoute(data))
            }) {
                Text(text = "Go To Second Screen", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = msgFromNext ?: "Data not found",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}


@Composable
fun SecondScreen(navController: NavController, data: String?) {
    val context = LocalContext.current // Get the context
    // Reuse the CustomScaffold composable
    CustomScaffold(title = "Second Screen",
        onNavigationClick = {
            /* Handle back navigation */
            // Toast.makeText(context, "Back Arrow Clicked", Toast.LENGTH_SHORT).show()
            navController.previousBackStackEntry?.savedStateHandle?.set(
                "DATA_FROM_SECOND", "Data come from Second Screen"
            )
            navController.popBackStack()
        },
        false,
        topBarColor = Color.LightGray,
        titleColor = Color.White,
        tintColor = Color.White,
        navigationIcon = {
            Icon(Icons.Default.ArrowBack, contentDescription = "Home", tint = Color.White)
        }) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                // navController.navigate(RouteDestination.First.route)
                navController.previousBackStackEntry?.savedStateHandle?.set(
                    "DATA_FROM_SECOND", "Data come from Second Screen"
                )
                navController.popBackStack()
            }) {
                Text(text = "Go To First Screen", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data ?: "Data not found", fontSize = 24.sp, fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun AppNavigationDemo(navController: NavHostController) {
    NavHost(navController = navController, startDestination = RouteDestination.First.route) {
        composable(RouteDestination.First.route) {
            FirstScreen(navController)
        }
        composable(
            RouteDestination.Second.route, arguments = listOf(navArgument("DATA_KEY") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            SecondScreen(
                navController = navController,
                data = backStackEntry.arguments?.getString("DATA_KEY")
            )
        }
    }
}

sealed class RouteDestination(val route: String) {
    data object First : RouteDestination("first")
    data object Second : RouteDestination("first/{DATA_KEY}") {
        fun createRoute(data: String) = "first/$data"
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowPreviews(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    FirstScreen(navController)

}

@Preview(showSystemUi = true)
@Composable
fun ShowPreviews2(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    SecondScreen(navController, "Hello")
}

