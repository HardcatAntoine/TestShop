package com.assessment.testshop.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.assessment.testshop.R
import com.assessment.testshop.presentation.components.TestShopBottomTabRow
import com.assessment.testshop.presentation.navigation.CatalogDestination
import com.assessment.testshop.presentation.navigation.Route
import com.assessment.testshop.presentation.navigation.SignUpDestination
import com.assessment.testshop.presentation.navigation.TestShopNavHost
import com.assessment.testshop.presentation.navigation.navigateSingleTopTo
import com.assessment.testshop.presentation.navigation.testShopBottomNavScreens
import com.assessment.testshop.presentation.screen_cart.ShoppingCartScreen
import com.assessment.testshop.presentation.theme.TestShopTheme
import com.assessment.testshop.presentation.utils.resolveTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestShopApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestShopApp() {
    TestShopTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = testShopBottomNavScreens.find { destination ->
            destination.route == currentDestination?.route
        } ?: SignUpDestination

        Scaffold(
            topBar = {
                currentDestination?.route?.let {
                    if (it.contains(Route.PRODUCT_DETAILS.name)) {
                        TopAppBar(
                            title = { },
                            navigationIcon = {
                                IconButton(onClick = { navController.navigate(CatalogDestination.route) }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_back),
                                        contentDescription = "Back"
                                    )
                                }
                            }, actions = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_share),
                                        contentDescription = "Share"
                                    )
                                }
                            })
                    } else {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.height(60.dp),
                            title = {
                                Text(
                                    modifier = Modifier.padding(top = 16.dp),
                                    text = resolveTitle(it),
                                    fontSize = 20.sp
                                )
                            }
                        )
                    }

                }
            },
            bottomBar = {
                if (currentDestination?.route != Route.SIGN_UP.name) {
                    TestShopBottomTabRow(
                        allScreens = testShopBottomNavScreens,
                        onTabSelected = { destination ->
                            navController.navigateSingleTopTo(destination.route)
                        },
                        currentScreen = currentScreen
                    )
                }
            }
        ) { padding ->
            TestShopNavHost(navController = navController, modifier = Modifier.padding(padding))
        }
    }
}
