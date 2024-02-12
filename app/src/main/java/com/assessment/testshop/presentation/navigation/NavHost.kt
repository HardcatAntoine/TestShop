package com.assessment.testshop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.assessment.testshop.presentation.screen_cart.ShoppingCartScreen
import com.assessment.testshop.presentation.screen_catalog.CatalogScreen
import com.assessment.testshop.presentation.screen_main.MainScreen
import com.assessment.testshop.presentation.screen_profile.ProfileScreen
import com.assessment.testshop.presentation.screen_sales.SalesScreen
import com.assessment.testshop.presentation.screen_signup.SignUpScreen

@Composable
fun TestShopNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = SignUpDestination.route,
        modifier = modifier
    ) {
        composable(SignUpDestination.route) {
            SignUpScreen(onClick = {
                navController.navigateSingleTopTo(CatalogDestination.route)
            })
        }
        composable(CatalogDestination.route) {
            CatalogScreen()
        }
        composable(MainDestination.route) {
            MainScreen()
        }
        composable(ShoppingCartDestination.route) {
            ShoppingCartScreen()
        }
        composable(SalesDestination.route) {
            SalesScreen()
        }
        composable(ProfileDestination.route) {
            ProfileScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) {
    return this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}