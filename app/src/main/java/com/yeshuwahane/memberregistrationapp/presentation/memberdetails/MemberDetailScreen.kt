package com.yeshuwahane.memberregistrationapp.presentation.memberdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yeshuwahane.memberregistrationapp.presentation.MemberViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberDetailScreen(
    memberId: Int,
    onBackClick: () -> Unit
) {
    val viewModel = hiltViewModel<MemberViewModel>()
    val uiState by viewModel.memberState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getMemberById(memberId)
    }

    val member = uiState.member



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Member Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5)) // Light Gray Background
                .padding(16.dp)
        ) {
            if (member != null) {
                Text(
                    text = "Member Information",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                DynamicDetailCard(
                    title = "Personal Details",
                    details = mapOf(
                        "Name" to member?.name,
                        "Mobile No." to member?.mobile,
                        "Gender" to member?.gender,
                        "Date of Birth" to member?.dob,
                        "Caste" to member?.caste,
                        "Religion" to member?.religion,
                        "Category" to member?.category,
                        "Marital Status" to member?.maritalStatus,
                        "Date of Marriage" to member?.dateOfMarriage
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                DynamicDetailCard(
                    title = "Membership Details",
                    details = mapOf(
                        "Role" to member.role,
                        "Joining Date" to member.joiningDate,
                        "Subscription Fee" to member.subscriptionFee.toString(),
                        "Loan Amount" to member.loanAmount.toString(),
                        "Deposit Amount" to member.depositAmount.toString(),
                        "Aadhar No." to member.aadhar
                    )

                )
            } else {
                Text(
                    text = "Loading member details...",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun DynamicDetailCard(title: String, details: Map<String, String?>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            details.forEach { (label, value) ->
                if (!value.isNullOrEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "$label:",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier.weight(1f),
                            color = Color.Gray
                        )
                        Text(
                            text = value,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1.5f),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}