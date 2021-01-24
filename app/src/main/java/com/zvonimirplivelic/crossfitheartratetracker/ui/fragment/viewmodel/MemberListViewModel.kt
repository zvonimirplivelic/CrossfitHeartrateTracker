package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.zvonimirplivelic.crossfitheartratetracker.db.GymDatabase
import com.zvonimirplivelic.crossfitheartratetracker.db.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.model.GymMember
import kotlinx.coroutines.launch

class MemberListViewModel(
    val database: GymMemberDao,
    application: Application
) : AndroidViewModel(application) {

    private var memberList = MutableLiveData<List<GymMember?>>()

    init {
        initializeList()
    }

    private fun initializeList() {
        viewModelScope.launch {
            memberList.value = getListFromDatabase().value
        }
    }

    private suspend fun getListFromDatabase(): LiveData<List<GymMember>> {

        return database.getAllMembers()
    }


}