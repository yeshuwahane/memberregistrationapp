package com.yeshuwahane.memberregistrationapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "members")
data class MemberEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
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