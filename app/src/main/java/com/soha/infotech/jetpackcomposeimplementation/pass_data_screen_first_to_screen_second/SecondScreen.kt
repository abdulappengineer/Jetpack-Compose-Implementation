package com.soha.infotech.jetpackcomposeimplementation.pass_data_screen_first_to_screen_second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Step2: Design screen second

/**
 * Navigate back with result
 */

@Composable
//fun SecondScreen(data: String?) {
fun SecondScreen(navController: NavController, data: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = data ?: "No data found", fontSize = 14.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Put data into savedStateHandle to retrieve data on the previous screen
            navController.previousBackStackEntry?.savedStateHandle?.set("msg", "Data from Second:  Hi")
            navController.popBackStack()

        }) {
            Text(text = "Back")
        }
    }
}