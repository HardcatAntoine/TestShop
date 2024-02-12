package com.assessment.testshop.presentation.utils

import com.assessment.testshop.presentation.navigation.Route

fun resolveTitle(route: String): String {
    return when (route) {
        Route.SIGN_UP.name -> "Вход"
        Route.CATALOG.name -> "Каталог"
        Route.MAIN.name -> "Главная"
        Route.CART.name -> "Корзина"
        Route.SALES.name -> "Акции"
        Route.PROFILE.name -> "Профиль"
        Route.PRODUCT_DETAILS.name -> "Детали"
        else -> ""
    }
}