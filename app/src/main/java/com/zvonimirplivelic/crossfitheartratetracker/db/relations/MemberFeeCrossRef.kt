package com.zvonimirplivelic.crossfitheartratetracker.db.relations

import androidx.room.Entity
import java.util.*

@Entity(primaryKeys = ["uid", "membershipPaidDate"])
data class MemberFeeCrossRef (
    val uid: Long,
    val membershipPaidDate: Date
)