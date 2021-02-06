package com.zvonimirplivelic.crossfitheartratetracker.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gym_member_table")
data class MembershipFee(
    @PrimaryKey(autoGenerate = false)
    val membershipPaidDate: Date?,
)