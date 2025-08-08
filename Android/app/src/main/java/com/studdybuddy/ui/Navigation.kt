package com.studdybuddy.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.studdybuddy.ui.screens.HomeScreen
import com.studdybuddy.ui.screens.LoginScreen

object Destinations {
    const val LOGIN = "login"
    const val HOME = "home"
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.LOGIN) {
        composable(Destinations.LOGIN) { LoginScreen(onLogin = { navController.navigate(Destinations.HOME) }) }
        composable(Destinations.HOME) { HomeScreen() }
    }
}
