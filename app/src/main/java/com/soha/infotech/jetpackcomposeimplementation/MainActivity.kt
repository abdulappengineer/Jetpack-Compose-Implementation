package com.soha.infotech.jetpackcomposeimplementation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.soha.infotech.jetpackcomposeimplementation.components.CustomListView
import com.soha.infotech.jetpackcomposeimplementation.components.ScaffoldSample
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.BooksScreen
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.HomeScreen
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.MainScreen
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.MoviesScreen
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.MusicScreen
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.NavigationItem
import com.soha.infotech.jetpackcomposeimplementation.components.bottom_navigation_bar.ProfileScreen
import com.soha.infotech.jetpackcomposeimplementation.components.custom_view.RegistrationScreen
import com.soha.infotech.jetpackcomposeimplementation.components.pass_data_screen_first_to_screen_second.AppNavigation
import com.soha.infotech.jetpackcomposeimplementation.ui.theme.JetpackComposeImplementationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*JetpackComposeImplementationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.d("TAG", "onCreate: $innerPadding")
                  //  ScaffoldSample()
                    // CustomListView(innerPadding)
                }
            }*/

            /**
             * Bottom Navigation
             */
            // MainScreen()

            /**
             * Navigation (pass data from Screen A to Screen B)
             */
            val navController = rememberNavController()
            AppNavigation(navController = navController)

            /*val navController = rememberNavController()
            ABNavigation(navController)*/

            /**
             * Registration screen with Reusable Composable function
             */
            //RegistrationScreen()

        }
    }
}

/*@Composable
fun ABNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController = navController)
        }

        composable(
            "screenB/{data}",
            arguments = listOf(navArgument("data") {
                type = NavType.StringType
            })

        ) { backStackEntry ->
            ScreenB(data = backStackEntry.arguments?.getString("data"))
        }
    }
}*/

@Composable
fun ABNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = MyDestination.One.route) {
        composable(MyDestination.One.route) {
            ScreenA(navController = navController)
        }

        composable(
            MyDestination.Two.route,
            arguments = listOf(navArgument("data") {
                type = NavType.StringType
            })

        ) { backStackEntry ->
            ScreenB(data = backStackEntry.arguments?.getString("data"))
        }
    }
}

sealed class MyDestination(val route: String) {
    data object One : MyDestination("one")
    data object Two : MyDestination("two/{data}") {
        fun createRoute(newData: String) = "two/$newData"
    }
}

// Pass data from one screen to another
@Composable
fun ScreenA(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                isError = false
            },
            placeholder = {
                Text(text = "Enter the text")
            },
            label = {
                Text(text = "Give Text")
            },
            modifier = Modifier.fillMaxWidth()
        )
        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Field can not not be empty", color = Color.Red)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (text.isEmpty()) {
                    isError = true
                } else {
                    // navController.navigate("screenB/$text")
                    navController.navigate(MyDestination.Two.createRoute(text))
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Send Data",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ScreenB(data: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = data ?: "No data",
            fontSize = 24.sp
        )
    }
}