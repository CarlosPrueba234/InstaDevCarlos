package com.example.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instadev.view.auth.login.LoginScreen
import com.example.instadev.view.auth.register.RegisterScreen

object Destinations {
    const val LOGIN = "login"
    const val REGISTER = "register"
}

@Composable
fun NavigationWrapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.LOGIN
    ) {
        composable(Destinations.LOGIN) {
            LoginScreen(
                onCreateAccountClick = {
                    navController.navigate(Destinations.REGISTER)
                }
            )
        }
        composable(Destinations.REGISTER) {
            RegisterScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
