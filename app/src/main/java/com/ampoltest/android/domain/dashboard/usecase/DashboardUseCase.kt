package com.ampoltest.android.domain.dashboard.usecase

import com.ampoltest.android.domain.dashboard.model.AmpEnergy
import com.ampoltest.android.domain.dashboard.model.ElectricChargeDetails
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.domain.dashboard.model.UserOffer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * This usecase class is for getting all details in Dashboard screen
 */
class DashboardUseCase(private val dashboardRepository: DashboardRepository) {
    suspend fun getFuelDetails(): Flow<List<Fuel>> = flow {
        emit(dashboardRepository.getFuelDetails())
    }

    suspend fun getEVDetails(): Flow<ElectricChargeDetails> = flow {
        emit(dashboardRepository.getAmpChargeDetails())
    }

    suspend fun getEnergyDetails(): Flow<AmpEnergy> = flow {
        emit(dashboardRepository.getEnergyDetails())
    }

    suspend fun getUserOffersDetails(): Flow<UserOffer> = flow {
        emit(dashboardRepository.getCurrentOffers())
    }
}