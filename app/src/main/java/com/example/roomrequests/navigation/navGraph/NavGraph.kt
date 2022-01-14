package com.example.roomrequests.navigation.navGraph

import android.os.Build
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.roomrequests.navigation.MAIN_ROUTE
import com.example.roomrequests.navigation.ROUTE

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    owner: OnBackPressedDispatcherOwner
) {
    NavHost(
        navController = navHostController,
        startDestination = MAIN_ROUTE,
        route = ROUTE,
        builder = {
            mainNavGraph(navHostController,owner)
        }
    )
}