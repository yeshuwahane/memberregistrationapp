package com.yeshuwahane.memberregistrationapp.domain.repository

import com.yeshuwahane.memberregistrationapp.domain.model.Member


interface MemberRepository {
    suspend fun getAllMembers(): List<Member>
    suspend fun addMember(member: Member)
}