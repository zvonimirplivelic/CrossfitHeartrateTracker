package com.zvonimirplivelic.crossfitheartratetracker.db.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.MembershipFee

data class MemberWithFee(
    @Embedded val gymMember: GymMember,
    @Relation(
        parentColumn = "uid",
        entityColumn = "membershipPaidDate",
        associateBy = Junction(MemberFeeCrossRef::class)
    )
    val paidMembershipFeeList: List<MembershipFee?>
)