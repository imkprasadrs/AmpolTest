package com.ampoltest.android.domain.dashboard.usecase

import com.ampoltest.android.domain.dashboard.model.AmpEnergy
import com.ampoltest.android.domain.dashboard.model.ElectricChargeDetails
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.domain.dashboard.model.UserOffer

interface DashboardRepository {
    suspend fun getFuelDetails(): List<Fuel>
    suspend fun getAmpChargeDetails(): ElectricChargeDetails
    suspend fun getEnergyDetails(): AmpEnergy
    suspend fun getCurrentOffers(): UserOffer
}