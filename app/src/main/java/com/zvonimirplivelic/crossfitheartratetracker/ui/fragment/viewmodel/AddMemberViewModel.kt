package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.zvonimirplivelic.crossfitheartratetracker.db.dao.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import kotlinx.coroutines.launch
import timber.log.Timber

class AddMemberViewModel(
    val database: GymMemberDao,
    application: Application
) : AndroidViewModel(application) {

    init {
        onAddMember()
    }

    fun onAddMember() = viewModelScope.launch {
        val newMember = GymMember(0, "prvi", "član", 180, 80.0, 22)
        Timber.log(2, "Dodavanje ${newMember}")
        insertMember(newMember)
    }

    private suspend fun insertMember(newMember: GymMember) {
        database.insertMember(newMember)
    }
}
