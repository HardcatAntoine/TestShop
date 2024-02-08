package com.assessment.testshop.presentation.screen_signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val pattern = Regex("[А-Яа-яЁё]+")

    fun validateFirstName(firstName: String) {
        when {
            firstName.matches(pattern) -> _uiState.update { it.toFirstNameValid() }
            else -> _uiState.update { it.toFirstNameInvalid() }
        }
    }

    fun validateLastName(lastName: String) {
        when {
            lastName.matches(pattern) -> _uiState.update { it.toLastNameValid() }
            else -> _uiState.update { it.toLasNameInvalid() }
        }
    }

    fun validateSignUpForm(phoneNumber: String) {
        if (phoneNumber.length >= 10 && _uiState.value.isFirstNameValid && _uiState.value.isLastNameValid) {
            _uiState.update { it.toValidState() }
        }
    }
}