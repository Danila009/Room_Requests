package com.example.roomrequests.navigation.navGraph

import android.os.Build
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.annotation.RequiresApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.roomrequests.db.ViewModel
import com.example.roomrequests.navigation.MAIN_ROUTE
import com.example.roomrequests.navigation.NAME_SCHOOL_ARGUMENT
import com.example.roomrequests.navigation.NAME_STUDENT_ARGUMENT
import com.example.roomrequests.navigation.Screen
import com.example.roomrequests.screen.*

@RequiresApi(Build.VERSION_CODES.P)
fun NavGraphBuilder.mainNavGraph(
    navController: NavController,
    owner: OnBackPressedDispatcherOwner
) {
    navigation(
        startDestination = Screen.MainScreen.route,
        route = MAIN_ROUTE,
        builder = {
            composable(Screen.MainScreen.route){
                val viewModel = hiltViewModel<ViewModel>()
                MainScreen(
                    navComposable = navController,
                    viewModel = viewModel,
                    owner = owner
                )
            }
            composable(Screen.AddSchoolScreen.route){
                val viewModel = hiltViewModel<ViewModel>()
                AddSchoolScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(Screen.AddDirectorScreen.route, arguments = listOf(
                navArgument(
                    name = NAME_SCHOOL_ARGUMENT,
                    builder = {
                        type = NavType.StringType
                    }
                )
            )){
                val viewModel = hiltViewModel<ViewModel>()
                AddDirectorScreen(
                    navController = navController,
                    nameSchool = it.arguments?.getString(NAME_SCHOOL_ARGUMENT).toString(),
                    viewModel = viewModel
                )
            }
            composable(Screen.AddStudentScreen.route, arguments = listOf(
                navArgument(
                    name = NAME_SCHOOL_ARGUMENT,
                    builder = {
                        type = NavType.StringType
                    }
                )
            )){
                AddStudentScreen(
                    navController = navController,
                    nameSchool = it.arguments?.getString(NAME_SCHOOL_ARGUMENT).toString(),
                    viewModel = hiltViewModel()
                )
            }
            composable(Screen.AddSubjectScreen.route, arguments = listOf(
                navArgument(
                    name = NAME_STUDENT_ARGUMENT,
                    builder = {
                        type = NavType.StringType
                    }
                )
            )){
                AddSubjectScreen(
                    navController = navController,
                    viewModel = hiltViewModel(),
                    studentName = it.arguments?.getString(NAME_STUDENT_ARGUMENT).toString()
                )
            }
            composable(Screen.OpenSchool.route){

            }
        }
    )
}