package com.zvonimirplivelic.crossfitheartratetracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gym_member_table")
data class GymMember(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0L,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "second_name") val secondName: String?,
    @ColumnInfo(name = "height") val height: Int?,
    @ColumnInfo(name = "weight") val weight: Double?,
//    @ColumnInfo(name = "dateOfBirth") val dateOfBirth: Date?,
    @ColumnInfo(name = "age") val age: Int?

    )