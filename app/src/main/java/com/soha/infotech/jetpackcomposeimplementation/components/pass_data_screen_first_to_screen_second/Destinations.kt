package com.soha.infotech.jetpackcomposeimplementation.components.pass_data_screen_first_to_screen_second

// Step3: Create a Sealed class to define routes

sealed class Destinations(val route: String) {
    data object First : Destinations("first")

    data object Second : Destinations("second/{data}") {
        fun createRoute(data: String) = "second/$data"
    }
}