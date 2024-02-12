package com.assessment.testshop.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

object SignUpDestination : Destination {
    override val route: String = Route.SIGN_UP.name
    override val icon: ImageVector = Icons.Default.Warning
}

object CatalogDestination : Destination {
    override val route: String = Route.CATALOG.name
    override val icon: ImageVector = Icons.Outlined.Menu
}

object MainDestination : Destination {
    override val route: String = Route.MAIN.name
    override val icon: ImageVector = Icons.Outlined.Home
}

object ShoppingCartDestination : Destination {
    override val route: String = Route.CART.name
    override val icon: ImageVector = Icons.Outlined.ShoppingCart
}

object SalesDestination : Destination {
    override val route: String = Route.SALES.name
    override val icon: ImageVector = Icons.Outlined.Notifications
}

object ProfileDestination : Destination {
    override val route: String = Route.PROFILE.name
    override val icon: ImageVector = Icons.Outlined.Person
}
object ProductDetailsDestination:Destination{
    override val route: String = Route.PRODUCT_DETAILS.name
    override val icon: ImageVector = Icons.Outlined.Person


}

val testShopBottomNavScreens =
    listOf(
        MainDestination,
        CatalogDestination,
        ShoppingCartDestination,
        SalesDestination,
        ProfileDestination
    )