package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zvonimirplivelic.crossfitheartratetracker.db.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel.MemberListViewModel
import java.lang.IllegalArgumentException

class MemberListViewModelFactory(
    private val dataSource: GymMemberDao,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            return MemberListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown VM Class")
    }
}