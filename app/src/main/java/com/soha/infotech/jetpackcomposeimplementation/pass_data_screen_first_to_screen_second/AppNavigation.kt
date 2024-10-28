package com.soha.infotech.jetpackcomposeimplementation.pass_data_screen_first_to_screen_second

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlin.reflect.typeOf

// Step4: Create Navigation to navigate all screens

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.First.route) {
        composable(Destinations.First.route) {
            FirstScreen(navController = navController)
        }

        composable(
            Destinations.Second.route,
            arguments = listOf(navArgument("data") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            SecondScreen(
                navController = navController,
                data = backStackEntry.arguments?.getString("data")
            )
        }
    }
}