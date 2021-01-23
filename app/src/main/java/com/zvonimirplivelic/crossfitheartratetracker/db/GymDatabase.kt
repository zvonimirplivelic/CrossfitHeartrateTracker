package com.zvonimirplivelic.crossfitheartratetracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zvonimirplivelic.crossfitheartratetracker.model.GymMember

@Database(entities = arrayOf(GymMember::class), version = 1, exportSchema = false)
abstract class GymDatabase : RoomDatabase() {

    abstract val gymMemberDao: GymMemberDao

    companion object {
        @Volatile
        private var INSTANCE: GymDatabase? = null
        fun getInstance(context: Context): GymDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GymDatabase::class.java,
                        "crossfit_heartrate_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}