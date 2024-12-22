package com.yeshuwahane.memberregistrationapp.presentation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.domain.usecase.AddMemberUseCase
import com.yeshuwahane.memberregistrationapp.domain.usecase.GetMemberByIdUseCase
import com.yeshuwahane.memberregistrationapp.domain.usecase.GetMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MemberViewModel @Inject constructor(
    private val getMembersUseCase: GetMembersUseCase,
    private val addMemberUseCase: AddMemberUseCase,
    private val getMemberByIdUseCase: GetMemberByIdUseCase,
) : ViewModel() {

    private val _membersListState = MutableStateFlow(MemberListState(emptyList()))

    val membersListState = _membersListState
        .onStart {
            loadMembers()
        }
        .stateIn(
            viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
            initialValue = MemberListState(emptyList())
        )

    private val _memberState = MutableStateFlow(MemberState())
    val memberState = _memberState.asStateFlow()


    init {
        loadMembers()
    }

    private fun loadMembers() {
        viewModelScope.launch {
            val members = getMembersUseCase()
            _membersListState.update {
                it.copy(members = members)
            }
        }
    }

    fun addMember(member: Member) {
        viewModelScope.launch {
            addMemberUseCase(member)
            loadMembers()
        }
    }


    fun getMemberById(memberId: Int){

        viewModelScope.launch {
           val  member = getMemberByIdUseCase(memberId)
            _memberState.value = MemberState(member)

        }

    }



}

data class MemberListState(val members : List<Member>)
data class MemberState(val member: Member? = null)
