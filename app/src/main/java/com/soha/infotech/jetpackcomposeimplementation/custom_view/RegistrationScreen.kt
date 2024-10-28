package com.soha.infotech.jetpackcomposeimplementation.custom_view

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var errorMessage by remember { mutableStateOf("") }
    var isFormValid by remember { mutableStateOf(false) }

    val context = LocalContext.current  // Access the context

    fun validateForm() {
        isFormValid =
            username.isNotEmpty() &&
                    android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                    && password.length >= 8 &&
                    password == confirmPassword

        errorMessage = when {
            username.isBlank() -> "Username can not be empty"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email address"
            password.length < 8 -> "Password must be at least 8 characters"
            password != confirmPassword -> "Password do not match"
            else -> ""
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        CustomTextField(
            value = username,
            onValueChange = {
                username = it
                validateForm()
            },
            label = "Username",
            isError = username.isBlank(),
            errorMessage = "Username can  not be empty"
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            value = email,
            onValueChange = {
                email = it
                validateForm()
            },
            label = "Email",
            isError = !Patterns.EMAIL_ADDRESS.matcher(email).matches(),
            errorMessage = "Invalid email address",
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                validateForm()
            },
            label = "Password",
            isError = password.length < 8,
            errorMessage = "Password must be at least 8 characters",
            visualTransformation = PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                validateForm()
            },
            label = "Confirm Password",
            isError = password != confirmPassword,
            errorMessage = "Password do not match",
            visualTransformation = PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (isFormValid) {
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                }
            },
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }
    }
}