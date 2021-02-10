package com.zvonimirplivelic.crossfitheartratetracker

import com.zvonimirplivelic.crossfitheartratetracker.db.GymDatabase
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember

class GymTrackerRepository(
    val db: GymDatabase
) {

    fun getAllMembers() = db.gymMemberDao().getAllMembers()

    suspend fun insertMember(gymMember: GymMember) = db.gymMemberDao().insertMember(gymMember)
}