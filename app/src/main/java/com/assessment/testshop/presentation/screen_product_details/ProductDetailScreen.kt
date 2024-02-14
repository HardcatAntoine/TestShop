package com.assessment.testshop.presentation.screen_product_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assessment.testshop.R
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.presentation.components.FiveStarRating
import com.assessment.testshop.presentation.theme.ButtonGrey
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.TextGrey

@Composable
fun ProductDetailScreen() {
    val viewModel: ProductDetailsViewModel = hiltViewModel()
    val product by viewModel.uiState.collectAsState()


    product?.let { ProductDetailContent(product = it) }
}

@Composable
fun ProductDetailContent(product: Product) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(width = 340.dp, height = 368.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = product.imageRes),
                    contentDescription = "Product image"
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_half_favorite),
                        contentDescription = "Favorite button",
                        tint = EnabledButton
                    )
                }
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_help),
                        contentDescription = "Question button",
                        tint = TextGrey
                    )
                }
            }
        }
        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Icon(
                    modifier = Modifier.size(6.dp),
                    painter = painterResource(id = R.drawable.paggination_circle),
                    contentDescription = "pagination",
                    tint = EnabledButton
                )
                Spacer(modifier = Modifier.size(10.dp))
                Icon(
                    modifier = Modifier.size(6.dp),
                    painter = painterResource(id = R.drawable.paggination_circle),
                    contentDescription = "pagination",
                    tint = TextGrey
                )
                Spacer(modifier = Modifier.size(10.dp))
                Icon(
                    modifier = Modifier.size(6.dp),
                    painter = painterResource(id = R.drawable.paggination_circle),
                    contentDescription = "pagination",
                    tint = TextGrey
                )
                Spacer(modifier = Modifier.size(10.dp))
                Icon(
                    modifier = Modifier.size(6.dp),
                    painter = painterResource(id = R.drawable.paggination_circle),
                    contentDescription = "pagination",
                    tint = TextGrey
                )
            }
        }
        item {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = product.title,
                fontSize = 18.sp,
                style = TextStyle(color = TextGrey)
            )
        }
        item {
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                text = product.subtitle,
                fontSize = 20.sp
            )
        }
        item {
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                text = "Доступно для заказа ${product.available} штук",
                style = TextStyle(TextGrey),
            )
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                FiveStarRating(rating = product.feedback.rating)
                Spacer(modifier = Modifier.size(2.dp))
                Text(text = "${product.feedback.rating}", style = TextStyle(TextGrey))
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "${product.feedback.count} отзыва", style = TextStyle(TextGrey))
            }
        }
        item {
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${product.price.priceWithDiscount} ${product.price.unit}",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Box {
                    Text(
                        text = "${product.price.price} ${product.price.unit}",
                        fontSize = 12.sp,
                        style = TextStyle(TextGrey)
                    )
                    Image(
                        modifier = Modifier.padding(top = 5.dp),
                        painter = painterResource(id = R.drawable.discount_line),
                        contentDescription = "discount_line"
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                Box(
                    Modifier
                        .background(EnabledButton)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = "-${product.price.discount}%",
                        style = TextStyle(Color.White),
                        fontSize = 12.sp
                    )
                }
            }
        }
        item {
            Text(
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
                text = "Описание",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
        }
        item {
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
        }
        item {
            Text(modifier = Modifier.padding(top = 8.dp), text = product.description)
        }
        item {
            Text(
                modifier = Modifier.clickable { }.padding(top = 8.dp),
                text = "Скрыть", fontSize = 14.sp, style = TextStyle(TextGrey)
            )
        }
        item {
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "Характеристики",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
        }
        items(product.info) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = it.title)
                Text(text = it.value)
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Состав", fontSize = 20.sp, fontWeight = FontWeight(600))
                Icon(
                    painter = painterResource(id = R.drawable.ic_copy),
                    contentDescription = "Copy",
                    tint = TextGrey
                )
            }


        }
        item {
            Text(modifier = Modifier.padding(top = 8.dp), text = product.ingredients, maxLines = 2)
        }
        item {
            Text(
                modifier = Modifier.clickable { }.padding(top = 8.dp),
                text = "Подробнее", fontSize = 14.sp, style = TextStyle(TextGrey)
            )
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(EnabledButton),
                onClick = {}
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${product.price.priceWithDiscount} ${product.price.unit}",
                                fontSize = 20.sp,
                                style = TextStyle(Color.White)
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                            Box {
                                Text(
                                    text = "${product.price.price} ${product.price.unit}",
                                    fontSize = 12.sp,
                                    style = TextStyle(TextGrey)
                                )
                                Image(
                                    modifier = Modifier.padding(top = 5.dp),
                                    painter = painterResource(id = R.drawable.discount_line),
                                    contentDescription = "discount_line"
                                )
                            }
                        }

                    }
                    Text(text = "Добавить в корзину", style = TextStyle(Color.White))
                }
            }
        }
    }
}




