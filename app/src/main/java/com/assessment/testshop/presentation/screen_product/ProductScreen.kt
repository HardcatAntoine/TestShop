package com.assessment.testshop.presentation.screen_product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assessment.testshop.R
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.presentation.theme.ButtonBackInvisible
import com.assessment.testshop.presentation.theme.ButtonGrey
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.TextGrey

@Composable
fun ProductScreen(product: Product) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .background(Color.White)
        .verticalScroll(scrollState)) {
        TopBar()
        Box(
            modifier = Modifier
                .size(width = 340.dp, height = 368.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = "Product image"
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite button"
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_question),
                    contentDescription = "Question button"
                )
            }
        }
        Icon(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "pagination"
        )
        Text(text = product.title, fontSize = 16.sp, style = TextStyle(color = TextGrey))
        Text(text = product.subtitle, fontSize = 20.sp)
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
            text = "Доступно для заказа ${product.available} штук",
            style = TextStyle(TextGrey),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Rating"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Rating"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Rating"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Rating"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Rating"
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(text = "${product.feedback.rating}")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "${product.feedback.count} отзыва")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = product.price.priceWithDiscount, fontSize = 24.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = product.price.price, fontSize = 16.sp, style = TextStyle(TextGrey))
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "-${product.price.discount}%",
                Modifier
                    .background(EnabledButton)
                    .padding(start = 5.dp, end = 5.dp, top = 1.dp, bottom = 1.dp),
                style = TextStyle(Color.White),
                fontSize = 12.sp
            )
        }
        Text(
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
            text = "Описание",
            fontSize = 16.sp
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                ButtonGrey, Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {},
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = product.title, fontSize = 16.sp)
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_right_stroke),
                    contentDescription = "Right stroke"
                )
            }
        }
        Text(text = product.description)
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(ButtonBackInvisible),
            onClick = {}
        ) {
            Text(text = "Скрыть", fontSize = 14.sp, style = TextStyle(TextGrey))
        }
        Text(text = "Характеристики", fontSize = 20.sp)
        Box(modifier = Modifier.fillMaxWidth()) {
            LazyColumn {
                itemsIndexed(product.info) { _, item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item.title)
                        Text(text = item.value)
                    }
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Состав", fontSize = 20.sp)
            Icon(painter = painterResource(id = R.drawable.ic_copy), contentDescription = "Copy")
        }
        Text(text = product.ingredients, maxLines = 2)
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(ButtonBackInvisible),
            onClick = {}
        ) {
            Text(text = "Подробнее", fontSize = 14.sp, style = TextStyle(TextGrey))
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(EnabledButton),
            onClick = {}
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box {
                    Text(text = product.price.priceWithDiscount, fontSize = 24.sp, style = TextStyle(Color.White))
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = product.price.price, fontSize = 16.sp, style = TextStyle(TextGrey))
                }
                Text(text = "Добавить в корзину", style = TextStyle(Color.White))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = {},
        navigationIcon = {
            IconButton(onClick = { }) {
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
}