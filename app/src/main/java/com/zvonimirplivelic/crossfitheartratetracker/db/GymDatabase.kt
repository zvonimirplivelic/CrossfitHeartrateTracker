package com.zvonimirplivelic.crossfitheartratetracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zvonimirplivelic.crossfitheartratetracker.db.dao.GymMemberDao
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.Exercise
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.MembershipFee
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberExerciseCrossRef
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberFeeCrossRef
import com.zvonimirplivelic.crossfitheartratetracker.util.Converters

@Database(
    entities = [
        GymMember::class,
        Exercise::class,
        MembershipFee::class,
        MemberFeeCrossRef::class,
        MemberExerciseCrossRef::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
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