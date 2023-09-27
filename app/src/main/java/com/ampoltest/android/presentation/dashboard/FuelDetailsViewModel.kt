package com.ampoltest.android.presentation.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FuelDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    init {
        /**
         * Need to capture the passed value from previous screen here using savedStateHandle
         */
    }
}