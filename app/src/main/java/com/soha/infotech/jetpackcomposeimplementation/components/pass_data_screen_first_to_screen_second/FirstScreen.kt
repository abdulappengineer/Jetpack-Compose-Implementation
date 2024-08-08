package com.soha.infotech.jetpackcomposeimplementation.components.pass_data_screen_first_to_screen_second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Step1: Design screen one

@Composable
fun FirstScreen(navController: NavController) {

    var text by remember { mutableStateOf("") }
    // error state for edit text
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
                // Reset error state on text change
                isError = false
            },
            label = {
                Text(text = "Text")
            },
            placeholder = {
                Text(text = "Enter text")
            },
            isError = isError,
            modifier = Modifier
                .fillMaxWidth()
            // .padding(bottom = 16.dp)
        )
        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Text cannot be empty", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (text.isEmpty()) {
                    // Show error if text is empty
                    isError = true
                } else {
                    navController.navigate(Destinations.Second.createRoute(text))
                }
            },
            // set button center horizontally
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Send Data", color = Color.White)
        }
    }
}