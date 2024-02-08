package com.assessment.testshop.presentation.screen_signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assessment.testshop.presentation.components.NameField
import com.assessment.testshop.presentation.components.PhoneField
import com.assessment.testshop.presentation.theme.DisabledButton
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.TextGrey


@Composable
fun SignUpScreen(onClick: () -> Unit) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.padding(top = 150.dp)) {
            Column {
                NameField(
                    hint = "Имя",
                    isError = !uiState.value.isFirstNameValid,
                    onTextChanged = { viewModel.validateFirstName(it) })
                NameField(
                    hint = "Фамилия",
                    isError = !uiState.value.isLastNameValid,
                    onTextChanged = { viewModel.validateLastName(it) })
                PhoneField(onPhoneChanged = { viewModel.validateSignUpForm(it) })
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                    shape = RoundedCornerShape(8.dp),
                    enabled = uiState.value.isButtonEnabled,
                    colors = ButtonDefaults.buttonColors(
                        EnabledButton,
                        Color.White,
                        DisabledButton,
                        TextGrey
                    ),
                    onClick = {
                        onClick()
                    }) {
                    Text(text = "Войти")
                }
            }
        }
        Box(modifier = Modifier.padding(bottom = 5.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Нажимая кнопку “Войти”, Вы принимаете",
                    color = TextGrey, fontSize = 12.sp
                )
                Text(
                    text = "условия программы лояльности",
                    fontSize = 12.sp,
                    color = TextGrey,
                    textDecoration = TextDecoration.Underline
                )
            }

        }
    }
}


