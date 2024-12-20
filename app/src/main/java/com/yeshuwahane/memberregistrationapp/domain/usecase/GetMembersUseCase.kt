package com.yeshuwahane.memberregistrationapp.domain.usecase

import com.yeshuwahane.memberregistrationapp.domain.repository.MemberRepository


class GetMembersUseCase(private val repository: MemberRepository) {
    suspend operator fun invoke() = repository.getAllMembers()
}