package com.ampoltest.android.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ampoltest.android.domain.dashboard.model.AmpEnergy
import com.ampoltest.android.domain.dashboard.model.ElectricChargeDetails
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.domain.dashboard.model.UserOffer
import com.ampoltest.android.domain.dashboard.usecase.DashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardUiModel(
    val isLoading: Boolean = false,
    val fuel: List<Fuel> = listOf(),
    val evCharge: ElectricChargeDetails? = null,
    val energy: AmpEnergy? = null,
    val userOffer: UserOffer? = null
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardUseCase: DashboardUseCase
) : ViewModel() {
    val uiModel: MutableStateFlow<DashboardUiModel> = MutableStateFlow(DashboardUiModel())
    private val channel = Channel<DashboardAction>(Channel.BUFFERED)
    val action = channel.receiveAsFlow()

    init {
        viewModelScope.launch {
            updateFuelDetails()
            updateElectricChargeDetails()
            updateEnergyDetails()
            updateUserOfferDetails()
        }
    }

     fun onShowAllFuelTransactionsButtonTapped() {
        viewModelScope.launch {
            channel.send(DashboardAction.NavigateToFuelDetails(uiModel.value.fuel))
        }
    }

    private suspend fun updateFuelDetails() {
        dashboardUseCase.getFuelDetails().collectLatest {
            uiModel.value = uiModel.value.copy(fuel = it)
        }
    }

    private suspend fun updateElectricChargeDetails() {
        dashboardUseCase.getEVDetails().collectLatest {
            uiModel.value = uiModel.value.copy(evCharge = it)
        }
    }

    private suspend fun updateEnergyDetails() {
        dashboardUseCase.getEnergyDetails().collectLatest {
            uiModel.value = uiModel.value.copy(energy = it)
        }
    }

    private suspend fun updateUserOfferDetails() {
        dashboardUseCase.getUserOffersDetails().collectLatest {
            uiModel.value = uiModel.value.copy(userOffer = it)
        }
    }
}

sealed class DashboardAction {
    data class NavigateToFuelDetails(val fuels: List<Fuel>) : DashboardAction()
}