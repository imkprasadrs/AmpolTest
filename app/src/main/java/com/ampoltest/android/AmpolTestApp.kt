package com.ampoltest.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AmpolTestApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}