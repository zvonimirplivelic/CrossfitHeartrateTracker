package com.zvonimirplivelic.crossfitheartratetracker.db.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "exercise_name") val exerciseName: String?,
    @ColumnInfo(name = "rep_quantity") val repQuantity: Int
) {
}