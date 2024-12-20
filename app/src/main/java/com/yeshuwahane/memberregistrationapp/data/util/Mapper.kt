package com.yeshuwahane.memberregistrationapp.data.util

import com.yeshuwahane.memberregistrationapp.data.model.MemberEntity
import com.yeshuwahane.memberregistrationapp.domain.model.Member

// Extensions for mapping between domain and entity models
fun MemberEntity.toDomainModel() = Member(
    id, name, mobile, role, subscriptionFee, depositAmount, loanAmount, gender,
    dob, joiningDate, maritalStatus, dateOfMarriage, caste, religion, category, aadhar
)

fun Member.toEntity() = MemberEntity(
    id, name, mobile, role, subscriptionFee, depositAmount, loanAmount, gender,
    dob, joiningDate, maritalStatus, dateOfMarriage, caste, religion, category, aadhar
)