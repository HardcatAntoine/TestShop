package com.assessment.testshop.presentation.screen_signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.testshop.data.ProfileRepository
import com.assessment.testshop.data.local.Person
import com.assessment.testshop.domain.GetProfileDataUseCase
import com.assessment.testshop.domain.InsertProfileDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val insertProfileDataUseCase: InsertProfileDataUseCase,
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val _person = MutableStateFlow(String())
    val person = _person.asStateFlow()

    private val pattern = Regex("[А-Яа-яЁё]+")

    private var firstName: String = ""
    private var lastName: String = ""
    private var phoneNumber: String = ""

    init {
        getPerson()
    }

    fun validateFirstName(firstName: String) {
        this.firstName = firstName
        when {
            firstName.matches(pattern) -> _uiState.update { it.toFirstNameValid() }
            else -> _uiState.update { it.toFirstNameInvalid() }
        }
    }

    fun validateLastName(lastName: String) {
        this.lastName = lastName
        when {
            lastName.matches(pattern) -> _uiState.update { it.toLastNameValid() }
            else -> _uiState.update { it.toLasNameInvalid() }
        }
    }

    fun validatePhoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    fun validateSignUpForm() {
        if (firstName == "") _uiState.update { it.toFirstNameInvalid() }
        if (lastName == "") _uiState.update { it.toLasNameInvalid() }
        if (phoneNumber.length >= 10 && _uiState.value.isFirstNameValid && _uiState.value.isLastNameValid) {
            _uiState.update { it.toValidState() }
        } else {
            _uiState.update { it.toInitState() }
        }
    }

    fun savePerson() {
        viewModelScope.launch {
            insertProfileDataUseCase(firstName, lastName, phoneNumber)
        }
    }

    private fun getPerson() {
        viewModelScope.launch {
            val person = getProfileDataUseCase.invoke()
            if (person == null) {
                _person.update { "" }
            } else {
                _person.update { person.phoneNumber }
            }
        }
    }
}