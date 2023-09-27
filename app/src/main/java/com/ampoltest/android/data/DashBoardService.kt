package com.ampoltest.android.data

import com.ampoltest.android.domain.dashboard.model.AmpEnergy
import com.ampoltest.android.domain.dashboard.model.ElectricChargeDetails
import com.ampoltest.android.domain.dashboard.model.Fuel
import com.ampoltest.android.domain.dashboard.model.UserOffer
import com.ampoltest.android.domain.dashboard.usecase.DashboardRepository

class DashBoardService : DashboardRepository {
    override suspend fun getFuelDetails(): List<Fuel> =
        listOf(
            Fuel(location = "Melbourne North", price = "178.9"),
            Fuel(location = "Melbourne NorthEast", price = "188.9"),
            Fuel(location = "Melbourne city", price = "200.9")
        )


    override suspend fun getAmpChargeDetails(): ElectricChargeDetails =
        ElectricChargeDetails(details = "test electric charge")

    override suspend fun getEnergyDetails(): AmpEnergy = AmpEnergy(energy = "Energryyy")

    override suspend fun getCurrentOffers(): UserOffer = UserOffer(offer = "10% off on fuels")
}