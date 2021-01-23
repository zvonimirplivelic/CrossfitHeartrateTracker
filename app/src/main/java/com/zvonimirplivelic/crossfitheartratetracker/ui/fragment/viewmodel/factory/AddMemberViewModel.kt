package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zvonimirplivelic.crossfitheartratetracker.db.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.AddMemberViewModel
import java.lang.IllegalArgumentException


class AddMemberViewModelFactory(
    private val dataSource: GymMemberDao,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddMemberViewModel::class.java)) {
            return AddMemberViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown VM Class")
    }
}