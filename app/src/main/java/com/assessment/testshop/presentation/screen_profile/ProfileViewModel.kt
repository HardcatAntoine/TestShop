package com.assessment.testshop.presentation.screen_profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.testshop.data.local.Person
import com.assessment.testshop.domain.GetFavoriteProductsCatalogUseCase
import com.assessment.testshop.domain.GetProductsCatalogUseCase
import com.assessment.testshop.domain.GetProfileDataUseCase
import com.assessment.testshop.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase,
    private val getFavoriteProductsCatalogUseCase: GetFavoriteProductsCatalogUseCase,
) : ViewModel() {
    private val _savedPerson = MutableStateFlow(Person())
    val savedPerson = _savedPerson.asStateFlow()

    private val _favoriteProductsListSize = MutableStateFlow(0)
    val favoriteProductsListSize = _favoriteProductsListSize.asStateFlow()

    init {
        getPersonData()
    }

    private fun getPersonData() {
        viewModelScope.launch {
            _savedPerson.update { getProfileDataUseCase.invoke()!! }
        }
    }
     fun getFavoriteProductsListSize() {
        viewModelScope.launch {
           val list =  getFavoriteProductsCatalogUseCase.invoke()
            _favoriteProductsListSize.update { list.size }
            Log.d("LIST Size", "${list.size}")
        }
    }
}
