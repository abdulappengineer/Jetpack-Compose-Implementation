package com.soha.infotech.jetpackcomposeimplementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.soha.infotech.jetpackcomposeimplementation.product.model.Product
import com.soha.infotech.jetpackcomposeimplementation.user_list_user_item.DataManager
import com.soha.infotech.jetpackcomposeimplementation.user_list_user_item.Pages
import com.soha.infotech.jetpackcomposeimplementation.user_list_user_item.UserDetail
import com.soha.infotech.jetpackcomposeimplementation.user_list_user_item.UserListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /**
             * Prepare the list
             */
            val productList = mutableListOf(
                Product(
                    R.drawable.ic_launcher_background,
                    "Apple",
                    "Crisp, juicy, and vitamin-rich."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Banana",
                    "Soft, sweet, and high in potassium."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Orange",
                    "Tangy, juicy, and vitamin C-packed."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Strawberry",
                    "Sweet, red, and antioxidant-rich."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Mango",
                    "Juicy, tropical, and flavorful."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Grapes",
                    "Small, sweet, and juicy clusters."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Pineapple",
                    "Sweet, tangy, and tropical."
                ),
                Product(
                    R.drawable.ic_launcher_background,
                    "Blueberry",
                    "Sweet-tart, small, and antioxidant-rich."
                ),
                Product(R.drawable.ic_launcher_background, "Peach", "Juicy, sweet, and fragrant."),
                Product(
                    R.drawable.ic_launcher_background,
                    "Watermelon",
                    "Refreshing, sweet, and hydrating."
                ),
            )

            /**
             * Display product list
             */
            /* JetpackComposeImplementationTheme {
                 Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                     Log.d("TAG", "onCreate: $innerPadding")
                   //  ScaffoldSample()
                     // CustomListView(innerPadding)
                     ProductList(list = productList, innerPadding)
                 }
             }*/

            /**
             * Bottom Navigation
             */
            // MainScreen()

            /**
             * Navigation (pass data from Screen A to Screen B)
             */
            /*val navController = rememberNavController()
            AppNavigation(navController = navController)*/

            /*val navController = rememberNavController()
            ABNavigation(navController)*/

            /**
             * Registration screen with Reusable Composable function
             */
            //RegistrationScreen()

            /**
             * Reusability of Jetpack Compose Components
             */
            /*MyButton( text = "My Custom Button",
                backgroundColor = Color.Blue,
                roundedRadius = 8.dp,
                leadingIcon = {
                    Icon(Icons.Filled.Star, contentDescription = null)
                },
                onClick = {
                    // Perform action when button is clicked
                }
            )*/

            // Navigation Test here
            /* val navController = rememberNavController()
             AppNavigationDemo(navController)*/

            App()

        }

        /* // Prepare userList in Background thread
         CoroutineScope(Dispatchers.IO).launch {
             DataManager.loadUser()
         }*/
    }
}

@Preview
@Composable
fun App() {
    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            // delay(5000)
            DataManager.loadUser()
        }
    }
    if (DataManager.isDataLoaded.value) {

        /*if (DataManager.currentPage.value == Pages.LISTING){
            UserListScreen(userList = DataManager.userList) {
                DataManager.switchPages(it)
            }

        }else{
            DataManager.currentUser?.let { UserDetail(user = it) }
        }*/

        when (DataManager.currentPage.value) {
            Pages.LISTING -> {
                UserListScreen(userList = DataManager.userList) { selectedUser ->
                    DataManager.switchPages(selectedUser)
                }
            }

            Pages.DETAIL -> {
                DataManager.currentUser?.let { user ->
                    UserDetail(user = user)
                }
            }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineLarge
            )
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