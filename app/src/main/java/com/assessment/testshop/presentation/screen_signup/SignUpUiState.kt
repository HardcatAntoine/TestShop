package com.assessment.testshop.presentation.screen_signup

data class SignUpUiState(
    val isFirstNameValid: Boolean = true,
    val isLastNameValid: Boolean = true,
    val isButtonEnabled: Boolean = false,
) {
    fun toInitState(): SignUpUiState {
        return this.copy(
            isFirstNameValid = true,
            isLastNameValid = true,
            isButtonEnabled = false,
        )
    }

    fun toFirstNameInvalid(): SignUpUiState {
        return this.copy(isFirstNameValid = false)
    }

    fun toFirstNameValid(): SignUpUiState {
        return this.copy(isFirstNameValid = true)
    }

    fun toLasNameInvalid(): SignUpUiState {
        return this.copy(isLastNameValid = false)
    }

    fun toLastNameValid(): SignUpUiState {
        return this.copy(isLastNameValid = true)
    }

    fun toValidState(): SignUpUiState {
        return this.copy(
            isFirstNameValid = true,
            isLastNameValid = true,
            isButtonEnabled = true,
        )
    }
}