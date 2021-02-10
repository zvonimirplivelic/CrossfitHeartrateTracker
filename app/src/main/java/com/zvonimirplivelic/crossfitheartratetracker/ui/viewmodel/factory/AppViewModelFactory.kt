package com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zvonimirplivelic.crossfitheartratetracker.GymTrackerRepository
import com.zvonimirplivelic.crossfitheartratetracker.db.dao.GymTrackerDao
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.GymTrackerViewModel
import java.lang.IllegalArgumentException

class AppViewModelFactory(
    private val gymTrackerRepository: GymTrackerRepository,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GymTrackerViewModel::class.java)) {
            return GymTrackerViewModel(gymTrackerRepository, application) as T
        }
        throw IllegalArgumentException("Unknown VM Class")
    }
}