package com.ampoltest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ampoltest.android.foundation.Navigation
import com.ampoltest.android.ui.theme.AmpolTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmpolTestTheme {
                Navigation()
            }
        }
    }
}

