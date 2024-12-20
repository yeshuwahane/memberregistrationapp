package com.yeshuwahane.memberregistrationapp.domain.usecase

import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.domain.repository.MemberRepository


class AddMemberUseCase(private val repository: MemberRepository) {
    suspend operator fun invoke(member: Member) = repository.addMember(member)
}