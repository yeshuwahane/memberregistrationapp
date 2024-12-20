package com.yeshuwahane.memberregistrationapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.domain.usecase.AddMemberUseCase
import com.yeshuwahane.memberregistrationapp.domain.usecase.GetMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MemberViewModel @Inject constructor(
    private val getMembersUseCase: GetMembersUseCase,
    private val addMemberUseCase: AddMemberUseCase
) : ViewModel() {
    val members = MutableStateFlow<List<Member>>(emptyList())

    init {
        loadMembers()
    }

    private fun loadMembers() {
        viewModelScope.launch {
            members.value = getMembersUseCase()
        }
    }

    fun addMember(member: Member) {
        viewModelScope.launch {
            addMemberUseCase(member)
            loadMembers()
        }
    }
}