package com.assessment.testshop.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneField(
    onPhoneChanged: (String) -> Unit
) {

    val phoneNumber = remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        ),
        trailingIcon = {
            TrailingIcon(text = phoneNumber.value) {
                phoneNumber.value = ""
                onPhoneChanged(phoneNumber.value)
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        placeholder = { Text(text = "Номер телефона") },
        value = phoneNumber.value,
        onValueChange = { it ->
            val formattedPhoneNumber = it.take(MASK.count { it == MASK_NUMBER })
            onPhoneChanged(formattedPhoneNumber)
            phoneNumber.value = formattedPhoneNumber
            Log.d("NUMBER", it.length.toString())
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(MASK, MASK_NUMBER)
    )
}
