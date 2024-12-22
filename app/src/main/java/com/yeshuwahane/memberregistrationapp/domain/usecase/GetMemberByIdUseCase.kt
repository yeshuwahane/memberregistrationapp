package com.yeshuwahane.memberregistrationapp.domain.usecase

import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.domain.repository.MemberRepository
import javax.inject.Inject


class GetMemberByIdUseCase @Inject constructor(
    private val repository: MemberRepository
) {
    suspend operator fun invoke(memberId: Int): Member? {
        return repository.getMemberById(memberId)
    }
}
