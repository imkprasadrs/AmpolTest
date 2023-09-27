package com.ampoltest.android.foundation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.presentation.screens.DashboardScreen

fun NavGraphBuilder.dashboardComposable(navigateToFuelsDetails: (List<Fuel>) -> Unit) {
    composable(route = AmpolScreens.DASHBOARDSCREEN) {
        DashboardScreen(onShowAllFuelTransactionButtonTapped = navigateToFuelsDetails)
    }
}