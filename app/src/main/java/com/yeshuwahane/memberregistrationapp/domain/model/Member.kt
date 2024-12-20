package com.yeshuwahane.memberregistrationapp.domain.model



data class Member(
    val id: Int = 0,
    val name: String,
    val mobile: String,
    val role: String,
    val subscriptionFee: Double,
    val depositAmount: Double,
    val loanAmount: Double,
    val gender: String,
    val dob: String,
    val joiningDate: String,
    val maritalStatus: String,
    val dateOfMarriage: String?,
    val caste: String?,
    val religion: String?,
    val category: String?,
    val aadhar: String?
)
