package com.zvonimirplivelic.crossfitheartratetracker.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zvonimirplivelic.crossfitheartratetracker.model.GymMember

@Dao
interface GymMemberDao {
    @Insert
    suspend fun insertMember(gymMember: GymMember)

    @Update
    suspend fun update(gymMember: GymMember)

    @Query("DELETE FROM gym_member_table")
    suspend fun deleteAllGymMembers()

    @Query("DELETE FROM gym_member_table WHERE uid = :memberId")
    suspend fun deleteGymMember(memberId: Long): GymMember?

    @Query("SELECT * FROM gym_member_table WHERE uid = :memberId")
    suspend fun getGymMember(memberId: Long): GymMember?

    @Query("SELECT * FROM gym_member_table ORDER BY uid DESC")
    fun getAllMembers(): LiveData<List<GymMember>>
}