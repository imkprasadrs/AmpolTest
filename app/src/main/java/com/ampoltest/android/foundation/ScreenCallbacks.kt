package com.ampoltest.android.foundation

import androidx.navigation.NavHostController
import com.ampoltest.android.domain.dashboard.model.Fuel

class ScreenNavigationCallbacks(navController: NavHostController) {
    /**
     * Below functions are used as a call back functions for various navigations
     */

    val dashboard: (List<Fuel>) -> Unit = {
        navController.navigate(route = AmpolScreens.FUELSDETAILSCREEN)
        /**
         * We need to wrap this list to an object and pass
         */
        // navController.navigate(route = AmpolScreens.FUELSDETAILSCREEN + "/${it}")
    }

}