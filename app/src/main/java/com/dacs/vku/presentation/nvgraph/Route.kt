package com.dacs.vku.presentation.nvgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen: Route(route= "OnBoardingScreen")
    object HomeScreen: Route(route= "HomeScreen")
    object SearchScreen: Route(route= "SearchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")

    object DetailsScreen: Route(route = "detailsScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object VKUNavigation: Route(route = "VKUNavigation")
    object VKUNavigatorScreen: Route(route ="VKUNavigator")
    object VKULoginViaGmail: Route(route= "LoginViaGmail")
}