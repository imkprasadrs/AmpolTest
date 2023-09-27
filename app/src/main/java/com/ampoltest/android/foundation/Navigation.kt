package com.ampoltest.android.foundation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val screenCallbacks = ScreenNavigationCallbacks(navController)
    NavHost(
        navController = navController,
        startDestination = AmpolScreens.DASHBOARDSCREEN
    ) {
        dashboardComposable(navigateToFuelsDetails = screenCallbacks.dashboard)
        fuelDetailsComposable()
    }
}