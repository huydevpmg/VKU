package com.dacs.vku.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.dacs.vku.presentation.notification.NotiScreen
import com.dacs.vku.presentation.notification.NotificationViewModel
//import com.dacs.vku.presentation.notification.NotificationListScreen
//import com.dacs.vku.presentation.notification.NotificationViewModel
import com.dacs.vku.presentation.onboarding.OnBoardingScreen
import com.dacs.vku.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent

                )
            }
        }

        navigation(
            route = Route.VKUNavigation.route,
            startDestination = Route.DaotaoScreen.route
        ) {
            composable(
                route = Route.DaotaoScreen.route
            ) {
                val viewModel: NotificationViewModel = hiltViewModel()
                val notis = viewModel.noti.collectAsLazyPagingItems()
                NotiScreen(notis = notis, navigateToSearch = { /*TODO*/ }, navigateToDetails ={} )
            }
        }
    }
}