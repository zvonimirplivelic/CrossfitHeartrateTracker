package com.zvonimirplivelic.crossfitheartratetracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zvonimirplivelic.crossfitheartratetracker.GymTrackerRepository
import com.zvonimirplivelic.crossfitheartratetracker.R
import com.zvonimirplivelic.crossfitheartratetracker.db.GymDatabase
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.GymTrackerViewModel
import com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel.factory.AppViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: GymTrackerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gymTrackerRepository = GymTrackerRepository(GymDatabase(this))
        val viewModelProviderFactory = AppViewModelFactory(gymTrackerRepository, application)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(GymTrackerViewModel::class.java)
    }
}