package com.assessment.testshop.presentation.screen_product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
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
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.TextGrey

@Composable
@Preview(showBackground = true)
fun ProductScreen() {
    Column (modifier = Modifier.background(Color.White)){
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
        Text(text = "title", fontSize = 16.sp, style = TextStyle(color = TextGrey))
        Text(text = "Пенка для Умывания", fontSize = 20.sp)
        Text(text = "доступно для заказа")
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
            Text(text = "4.3")
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "4 отзыва")
        }
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = "549 Р", fontSize = 24.sp)
            Spacer(modifier =  Modifier.size(8.dp))
            Text(text = "899 Р", fontSize = 16.sp, style = TextStyle(TextGrey))
            Spacer(modifier =  Modifier.size(8.dp))
            Text(text = "-39%", Modifier.background(EnabledButton).padding(start = 5.dp, end = 5.dp, top = 1.dp, bottom = 1.dp), style = TextStyle(Color.White), fontSize = 12.sp)
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