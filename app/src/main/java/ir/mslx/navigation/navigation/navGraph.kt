package ir.mslx.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mslx.navigation.ui.screen.LoadingScreen
import ir.mslx.navigation.ui.screen.ProfileScreen


@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.loading.route
    ) {
        composable(Screens.loading.route) {
            LoadingScreen(
                onLoadingFinished = {
                    navController.navigate(Screens.Profile.route) {
                        popUpTo(Screens.loading.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Screens.Profile.route) {
            ProfileScreen()
        }
    }
}