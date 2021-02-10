package com.zvonimirplivelic.crossfitheartratetracker.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zvonimirplivelic.crossfitheartratetracker.GymTrackerRepository
import com.zvonimirplivelic.crossfitheartratetracker.db.dao.GymTrackerDao
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import kotlinx.coroutines.launch
import timber.log.Timber

class GymTrackerViewModel(
    val data: GymTrackerRepository,
    application: Application
) : AndroidViewModel(application) {


    private var memberList = MutableLiveData<List<GymMember?>>()



    init {
        initializeList()
    }


    fun onAddMember() = viewModelScope.launch {
        val newMember = GymMember(0, "prvi", "član")
        Timber.log(2, "Dodavanje ${newMember}")
        insertMember(newMember)
    }

    private fun initializeList() {
        viewModelScope.launch {
            memberList.value = getListFromDatabase().value
        }
    }

    private suspend fun insertMember(newMember: GymMember) {
        data.insertMember(newMember)
    }

    private suspend fun getListFromDatabase(): LiveData<List<GymMember>> {
        return data.getAllMembers()
    }
}
