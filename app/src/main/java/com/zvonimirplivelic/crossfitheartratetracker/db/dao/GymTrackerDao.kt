package com.zvonimirplivelic.crossfitheartratetracker.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.Exercise
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.GymMember
import com.zvonimirplivelic.crossfitheartratetracker.db.entites.MembershipFee
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberExerciseCrossRef
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberFeeCrossRef
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberWithExercise
import com.zvonimirplivelic.crossfitheartratetracker.db.relations.MemberWithFee

@Dao
interface GymTrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(gymMember: GymMember)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaidFee(membershipFee: MembershipFee)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemberExerciseCrossRef(crossRef: MemberExerciseCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemberFeeCrossRef(crossRef: MemberFeeCrossRef)

    @Query("DELETE FROM gym_member_table")
    suspend fun deleteAllGymMembers()

    @Query("DELETE FROM gym_member_table WHERE uid = :memberId")
    suspend fun deleteGymMember(memberId: Long)

    @Transaction
    @Query("SELECT * FROM gym_member_table WHERE uid = :memberId")
    suspend fun getMemberExerciseList(memberId: Long): List<MemberWithExercise>

    @Transaction
    @Query("SELECT * FROM gym_member_table WHERE uid = :memberId")
    suspend fun getMemberPaidFeeList(memberId: Long): List<MemberWithFee>

    @Query("SELECT * FROM gym_member_table ORDER BY uid DESC")
    fun getAllMembers(): LiveData<List<GymMember>>
}