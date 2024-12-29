package com.zzmr.bloom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome" // 设置默认界面
    ) {
        composable("welcome") { WelcomePage(navController) }
        composable("login") { LoginInPage(navController) }
    }
}
