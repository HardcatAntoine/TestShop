package com.assessment.testshop.presentation.screen_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.testshop.data.local.Person
import com.assessment.testshop.domain.GetProfileDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase
):ViewModel() {
    private val _savedPerson = MutableStateFlow(Person())
    val savedPerson = _savedPerson.asStateFlow()

    init {
        getPersonData()
    }
    private fun getPersonData(){
        viewModelScope.launch {
            _savedPerson.update { getProfileDataUseCase.invoke()!! }
        }
    }
}