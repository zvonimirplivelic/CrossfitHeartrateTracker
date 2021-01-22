package com.zvonimirplivelic.crossfitheartratetracker

import android.app.Application
import timber.log.Timber

class CrossfitHeartrateTrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}