package com.soha.infotech.jetpackcomposeimplementation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleTextField(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "Your Label")
        },
        placeholder = {
            Text(text = "Your Place Holder/Hint")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OutLineTextFieldSample(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "Enter your name")
        },
        placeholder = {
            Text(text = "Name")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Phone Icon")
        }
    )
}