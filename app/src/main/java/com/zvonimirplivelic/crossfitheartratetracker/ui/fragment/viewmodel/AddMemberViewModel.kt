package com.zvonimirplivelic.crossfitheartratetracker.ui.fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.zvonimirplivelic.crossfitheartratetracker.db.GymMemberDao

class AddMemberViewModel (
val database: GymMemberDao,
application: Application
) : AndroidViewModel(application) {

}