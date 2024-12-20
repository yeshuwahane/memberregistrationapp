package com.yeshuwahane.memberregistrationapp.data.repositoryimpl

import com.yeshuwahane.memberregistrationapp.data.datasource.MemberDao
import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.domain.repository.MemberRepository


class MemberRepositoryImpl(private val dao: MemberDao) : MemberRepository {
    override suspend fun getAllMembers(): List<Member> {
        return dao.getAllMembers().map { it.toDomainModel() }
    }

    override suspend fun addMember(member: Member) {
        dao.insertMember(member.toEntity())
    }
}

