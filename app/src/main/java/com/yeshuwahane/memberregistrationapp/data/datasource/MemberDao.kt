package com.yeshuwahane.memberregistrationapp.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yeshuwahane.memberregistrationapp.data.model.MemberEntity


@Dao
interface MemberDao {
    @Query("SELECT * FROM members")
    suspend fun getAllMembers(): List<MemberEntity>

    @Insert
    suspend fun insertMember(member: MemberEntity)
}
