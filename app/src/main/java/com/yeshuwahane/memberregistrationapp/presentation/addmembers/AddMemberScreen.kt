package com.yeshuwahane.memberregistrationapp.presentation.addmembers

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yeshuwahane.memberregistrationapp.domain.model.Member
import com.yeshuwahane.memberregistrationapp.presentation.MemberViewModel
import com.yeshuwahane.memberregistrationapp.presentation.utils.formatDate
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMemberScreen(onBack: () -> Unit) {
    val viewModel: MemberViewModel = hiltViewModel()
    val keyboardController = LocalSoftwareKeyboardController.current

    // Mutable states for all fields
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var subscriptionFee by remember { mutableStateOf("") }
    var depositAmount by remember { mutableStateOf("") }
    var maritalStatus by remember { mutableStateOf("") }
    var loanAmount by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var joiningDate by remember { mutableStateOf("") }
    var dateOfMarriage by remember { mutableStateOf("") }
    var caste by remember { mutableStateOf("") }
    var religion by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var aadhar by remember { mutableStateOf("") }

    // FocusRequesters for navigation
    val focusRequesters = List(12) { FocusRequester() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Member Registration") },
                navigationIcon = {
                    IconButton(onClick = { onBack.invoke() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .imePadding()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = mobile,
                onValueChange = { mobile = it },
                label = {
                    Text(
                        "Member Mobile Number", style = TextStyle(
                            color = Color.Black,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[0]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[1].requestFocus() }
                )
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Member Name", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[1]),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[2].requestFocus() }
                )
            )

            Text("Select Role",  style = TextStyle(
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Bold
            ))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = role == "Secretary",
                    onClick = { role = "Secretary" }
                )
                Text("Secretary", modifier = Modifier.padding(end = 16.dp), style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
                RadioButton(
                    selected = role == "Member",
                    onClick = { role = "Member" }
                )
                Text("Member", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
            }

            OutlinedTextField(
                value = subscriptionFee,
                onValueChange = { subscriptionFee = it },
                label = { Text("Subscription Fee", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[2]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[3].requestFocus() }
                )
            )

            OutlinedTextField(
                value = depositAmount,
                onValueChange = { depositAmount = it },
                label = { Text("Deposit Amount", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[3]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[4].requestFocus() }
                )
            )

            OutlinedTextField(
                value = loanAmount,
                onValueChange = { loanAmount = it },
                label = { Text("Loan Amount", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[4]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[5].requestFocus() }
                )
            )
            Text("Gender",  style = TextStyle(
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Bold
            ))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = gender == "Male",
                    onClick = { gender = "Male" }
                )
                Text("Male", modifier = Modifier.padding(end = 16.dp), style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
                RadioButton(
                    selected = gender == "Female",
                    onClick = { gender = "Female" }
                )
                Text("Female", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
            }

            OutlinedTextField(
                value =TextFieldValue(text = dob, selection = TextRange(dob.length)),
            onValueChange = {
                dob = formatDate(it.text)
            }
                ,
                label = { Text("Date of Birth (DOB)", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[5]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[6].requestFocus() }
                )
            )

            OutlinedTextField(
                value = TextFieldValue(text = joiningDate, selection = TextRange(joiningDate.length)),
                onValueChange = { joiningDate = formatDate(it.text) },
                label = { Text("Date of Joining", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[6]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[7].requestFocus() }
                )
            )

            Text("Marital Status",  style = TextStyle(
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.Bold
            ))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = maritalStatus == "Married",
                    onClick = { maritalStatus = "Married" }
                )
                Text("Married", modifier = Modifier.padding(end = 16.dp), style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
                RadioButton(
                    selected = maritalStatus == "Unmarried",
                    onClick = { maritalStatus = "Unmarried" }
                )
                Text("Unmarried", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ))
            }

            OutlinedTextField(
                value = TextFieldValue(text = dateOfMarriage, selection = TextRange(dateOfMarriage.length)),
                onValueChange = {
                    dateOfMarriage = formatDate(it.text)
                },
                label = { Text("Date of Marriage", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[7]),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequesters[8].requestFocus() }
                )
            )

            OutlinedTextField(
                value = caste,
                onValueChange = { caste = it },
                label = { Text("Caste", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[8]),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )

            OutlinedTextField(
                value = religion,
                onValueChange = { religion = it },
                label = { Text("Religion", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[9]),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[10]),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),

                )
            OutlinedTextField(
                value = aadhar,
                onValueChange = { aadhar = it },
                label = { Text("Aadhar No.", style = TextStyle(
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesters[10]),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                )
            )

            Button(
                onClick = {
                    val member = Member(
                        name = name,
                        mobile = mobile,
                        role = role,
                        subscriptionFee = subscriptionFee.toDoubleOrNull() ?: 0.0,
                        depositAmount = depositAmount.toDoubleOrNull() ?: 0.0,
                        loanAmount = loanAmount.toDoubleOrNull() ?: 0.0,
                        gender = gender,
                        dob = dob,
                        joiningDate = joiningDate,
                        maritalStatus = maritalStatus,
                        caste = caste,
                        religion = religion,
                        category = category,
                        aadhar = aadhar,
                        dateOfMarriage = dateOfMarriage
                    )
                    viewModel.addMember(member)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}

