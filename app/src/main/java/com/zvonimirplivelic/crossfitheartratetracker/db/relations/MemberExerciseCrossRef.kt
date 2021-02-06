package com.zvonimirplivelic.crossfitheartratetracker.db.relations

import androidx.room.Entity

@Entity(primaryKeys = ["uid", "exerciseName"])
data class MemberExerciseCrossRef(
    val uid: Long,
    val exerciseName: String
)