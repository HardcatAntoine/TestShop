package com.assessment.testshop.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assessment.testshop.presentation.navigation.Destination
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.TextGrey

@Composable
fun TestShopBottomTabRow(
    allScreens: List<Destination>,
    onTabSelected: (Destination) -> Unit,
    currentScreen: Destination
) {
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(
            Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            allScreens.forEach { screen ->
                TestShopBottomTab(
                    text = screen.route,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
private fun TestShopBottomTab(
    text: String,
    icon: Int,
    onSelected: () -> Unit,
    selected: Boolean
) {
    val formattedTitle = when (text) {
        "MAIN" -> "Главная"
        "CATALOG" -> "Каталог"
        "CART" -> "Корзина"
        "SALES" -> "Акции"
        "PROFILE" -> "Профиль"
        else -> ""
    }
    val color = EnabledButton
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else Color.Black,
        label = ""
    )
    Box {
        Icon(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Center)
                .selectable(
                    selected = selected,
                    onClick = onSelected,
                    role = Role.Tab,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(
                        bounded = false,
                        radius = Dp.Unspecified,
                        color = Color.Unspecified
                    )
                )
                .clearAndSetSemantics { contentDescription = text },
            painter = painterResource(id = icon),
            contentDescription = text,
            tint = tabTintColor
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 2.dp),
            text = formattedTitle,
            style = TextStyle(tabTintColor),
            fontSize = 10.sp
        )
    }

}

private val TabHeight = 56.dp

