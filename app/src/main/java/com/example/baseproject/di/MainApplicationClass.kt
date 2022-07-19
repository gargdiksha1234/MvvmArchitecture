package com.example.baseproject.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MainApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}