package com.sharath070.tweetsy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sharath070.tweetsy.screens.CategoryScreen
import com.sharath070.tweetsy.screens.TweetScreen

@Composable
fun TweetsyNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CategoryScreen.name) {
        composable(Screens.CategoryScreen.name) {
            CategoryScreen(navController = navController)
        }

        val route = Screens.TweetsScreen.name
        composable(
            route = "$route/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )
        ) {
            TweetScreen()
        }
    }
}