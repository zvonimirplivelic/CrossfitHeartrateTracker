package com.zvonimirplivelic.crossfitheartratetracker.db.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.Exercise
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember

data class MemberWithExercise(
    @Embedded val gymMember: GymMember,
    @Relation(
        parentColumn = "uid",
        entityColumn = "exerciseName",
        associateBy = Junction(MemberExerciseCrossRef::class)
    )
    val exerciseList: List<Exercise?>
)