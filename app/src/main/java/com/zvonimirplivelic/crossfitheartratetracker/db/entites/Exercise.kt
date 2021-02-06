package com.zvonimirplivelic.crossfitheartratetracker.db.entites

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    val exerciseName: String,
    val repQuantity: Int?
)