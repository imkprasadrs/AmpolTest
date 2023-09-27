package com.ampoltest.android.domain.dashboard.model

import java.io.Serializable

data class Fuel(val location: String, val price: String): Serializable
data class ElectricChargeDetails(val details: String)
data class AmpEnergy(val energy: String)
data class UserOffer(val offer: String)
