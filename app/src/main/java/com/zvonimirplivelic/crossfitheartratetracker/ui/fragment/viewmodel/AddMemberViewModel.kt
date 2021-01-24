package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zvonimirplivelic.crossfitheartratetracker.db.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.model.GymMember
import kotlinx.coroutines.launch

class AddMemberViewModel (
val database: GymMemberDao,
application: Application
) : AndroidViewModel(application) {

    fun onAddMember() {
        viewModelScope.launch {
            val newMember = GymMember(0, "prvi", "član", 180, 80.0, 22)
            insertMember(newMember)
        }
    }

    private suspend fun insertMember(newMember: GymMember) {
        database.insertMember(newMember)
    }
}