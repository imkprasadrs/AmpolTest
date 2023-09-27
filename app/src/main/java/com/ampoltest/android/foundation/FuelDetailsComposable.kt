package com.ampoltest.android.foundation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ampoltest.android.presentation.screens.FuelDetailsScreen

fun NavGraphBuilder.fuelDetailsComposable() {
    composable(route = AmpolScreens.FUELSDETAILSCREEN) {
        FuelDetailsScreen()
    }
}