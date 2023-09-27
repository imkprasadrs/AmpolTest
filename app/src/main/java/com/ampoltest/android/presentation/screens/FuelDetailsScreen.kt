package com.ampoltest.android.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ampoltest.android.presentation.dashboard.FuelDetailsViewModel

@Composable
fun FuelDetailsScreen(modifier: Modifier = Modifier) {
    val viewModel: FuelDetailsViewModel = hiltViewModel()
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Recent Transactions")
    }
}