package com.ampoltest.android.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ampoltest.android.domain.dashboard.model.AmpEnergy
import com.ampoltest.android.domain.dashboard.model.ElectricChargeDetails
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.domain.dashboard.model.UserOffer
import com.ampoltest.android.presentation.dashboard.DashboardAction
import com.ampoltest.android.presentation.dashboard.DashboardViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    onShowAllFuelTransactionButtonTapped: (List<Fuel>) -> Unit
) {
    val viewModel: DashboardViewModel = hiltViewModel()
    val content = viewModel.uiModel.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.action.collectLatest {
            when (it) {
                is DashboardAction.NavigateToFuelDetails -> onShowAllFuelTransactionButtonTapped(it.fuels)
            }
        }
    }
    Column(modifier = Modifier.padding(8.dp)) {
        LazyColumn() {
            item {
                if (content.fuel.isNotEmpty()) {
                    FuelCard(fuels = content.fuel) {
                        viewModel.onShowAllFuelTransactionsButtonTapped()
                    }
                }
            }
            item {
                content.evCharge?.let {
                    EVCard(content = it)
                }
            }
            item {
                content.userOffer?.let {
                    UserOffersCard(content = it)
                }
            }
            item {
                content.energy?.let {
                    EnergyCard(content = it)
                }
            }
        }
    }
}

@Composable
fun FuelCard(
    fuels: List<Fuel>,
    onButtonTapped: () -> Unit
) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Fuel Details")
            fuels.forEachIndexed { index, fuel ->
                if (index < 2) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(text = fuel.location)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = fuel.price)
                    }
                }
            }
            if (fuels.size > 2) {
                Button(onClick = { onButtonTapped.invoke() }) {
                    Text(text = "Show All")
                }
            }
        }
    }

}

@Composable
private fun ContentDetails(name: String, value: String) {
    Row() {
        Text(text = name, style = MaterialTheme.typography.labelLarge)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun EVCard(content: ElectricChargeDetails) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Electric Charge Details")
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = content.details)
            }
        }
    }
}

@Composable
fun UserOffersCard(content: UserOffer) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Offer Details")
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = content.offer)
            }
        }
    }
}

@Composable
fun EnergyCard(content: AmpEnergy) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Energy Details")
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = content.energy)
            }
        }
    }
}