package com.assessment.testshop.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.assessment.testshop.R

@Composable
fun TrailingIcon(text: String, onClearClick: () -> Unit) {
    if (text != "") {
        IconButton(onClick = { onClearClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null
            )
        }
    }
}