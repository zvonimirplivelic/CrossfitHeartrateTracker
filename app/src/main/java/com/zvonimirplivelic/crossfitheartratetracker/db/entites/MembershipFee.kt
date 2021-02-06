package com.zvonimirplivelic.crossfitheartratetracker.db.entites

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "membership_fee")
data class MembershipFee(
    @PrimaryKey(autoGenerate = false)
    val membershipPaidDate: Date?,
)