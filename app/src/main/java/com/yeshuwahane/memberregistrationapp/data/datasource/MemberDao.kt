package com.yeshuwahane.memberregistrationapp.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yeshuwahane.memberregistrationapp.data.model.MemberEntity
import com.yeshuwahane.memberregistrationapp.domain.model.Member


@Dao
interface MemberDao {
    @Query("SELECT * FROM members")
    suspend fun getAllMembers(): List<MemberEntity>

    @Insert
    suspend fun insertMember(member: MemberEntity)

    @Query("SELECT * FROM members WHERE id = :memberId LIMIT 1")
    suspend fun getMemberById(memberId: Int): Member? // New Query
}
