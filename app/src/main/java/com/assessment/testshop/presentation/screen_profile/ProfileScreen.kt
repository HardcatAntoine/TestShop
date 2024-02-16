package com.assessment.testshop.presentation.screen_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assessment.testshop.R
import com.assessment.testshop.data.local.Person
import com.assessment.testshop.presentation.components.MASK
import com.assessment.testshop.presentation.components.MASK_NUMBER
import com.assessment.testshop.presentation.components.PhoneVisualTransformation
import com.assessment.testshop.presentation.theme.ButtonGrey
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.IconPerson
import com.assessment.testshop.presentation.theme.RatingText
import com.assessment.testshop.presentation.theme.TextGrey

@Composable
@Preview(showBackground = true)
fun ProfileScreen() {
    val viewModel: ProfileViewModel = hiltViewModel()
    val savedPerson = viewModel.savedPerson.collectAsState().value
    val favoriteProductsListSize = viewModel.favoriteProductsListSize.collectAsState().value

    ProfileScreenContent(savedPerson, favoriteProductsListSize)

}

@Composable
fun ProfileScreenContent(savedPerson: Person, favoriteProductsListSize: Int) {
    val formattedPhoneNumber =
        PhoneVisualTransformation(
            MASK, MASK_NUMBER
        ).filter(AnnotatedString(savedPerson.phoneNumber))

    Column(modifier = Modifier.padding(8.dp)) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 12.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(ButtonGrey), onClick = { }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_person),
                            contentDescription = "person", tint = IconPerson
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = "${savedPerson.firstName} ${savedPerson.lastName}",
                                style = TextStyle(Color.Black)
                            )
                            Text(
                                text = formattedPhoneNumber.text,
                                style = TextStyle(TextGrey),
                                fontSize = 10.sp
                            )
                        }
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_log_out),
                    contentDescription = "log out", tint = Color.Black
                )
            }
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(ButtonGrey), onClick = { }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_half_favorite),
                            contentDescription = "person", tint = EnabledButton
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(text = "Избранное", style = TextStyle(Color.Black))
                            Text(
                                text = "$favoriteProductsListSize товаров",
                                style = TextStyle(TextGrey),
                                fontSize = 10.sp
                            )
                        }
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_stroke),
                    contentDescription = "log out", tint = Color.Black
                )
            }
        }
        ButtonElement(icon = R.drawable.ic_shops, title = "Магазины", tintColor = EnabledButton)
        ButtonElement(
            icon = R.drawable.ic_feedback,
            title = "Обратная связь",
            tintColor = RatingText
        )
        ButtonElement(icon = R.drawable.ic_oferta, title = "Оферта", tintColor = TextGrey)
        ButtonElement(icon = R.drawable.ic_return, title = "Возврат товара", tintColor = TextGrey)
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(ButtonGrey),
                onClick = { }) {
                Text(text = "Выйти", style = TextStyle(Color.Black))
            }
        }
    }
}

@Composable
fun ButtonElement(icon: Int, title: String, tintColor: Color) {
    Button(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(ButtonGrey),
        onClick = {}) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "icon",
                        tint = tintColor
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        style = TextStyle(Color.Black),
                        text = title
                    )
                }
            }
            Icon(
                painter = painterResource(R.drawable.ic_right_stroke),
                contentDescription = "right stroke",
                tint = Color.Black
            )
        }
    }
}
