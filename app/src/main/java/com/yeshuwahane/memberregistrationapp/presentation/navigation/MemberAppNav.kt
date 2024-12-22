package com.yeshuwahane.memberregistrationapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeshuwahane.memberregistrationapp.presentation.features.addmembers.AddMemberScreen
import com.yeshuwahane.memberregistrationapp.presentation.features.memberdetails.MemberDetailScreen
import com.yeshuwahane.memberregistrationapp.presentation.features.memberlist.MemberListScreen


@Composable
fun MemberAppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "memberList") {
        composable("memberList") {
            MemberListScreen(
                onAddMemberClick = {
                    navController.navigate("addMember")
                },
                onMemberClick = { memberId ->
                    navController.navigate("memberDetail/$memberId")
                }
            )
        }
        composable(
            "memberDetail/{memberId}",
            arguments = listOf(navArgument("memberId") { type = NavType.IntType })
        ) { backStackEntry ->
            val memberId = backStackEntry.arguments?.getInt("memberId") ?: -1
            MemberDetailScreen(
                memberId = memberId,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("addMember") {
            AddMemberScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}