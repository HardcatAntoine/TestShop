package com.assessment.testshop.presentation.screen_signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
) : ViewModel() {
    val enable = mutableStateOf(false)
    fun enabledButton(
        name: String,
        secondName: String,
        number: String,
    ) {
        enable.value = name != "" && secondName != "" && number.length >= 10
    }
}