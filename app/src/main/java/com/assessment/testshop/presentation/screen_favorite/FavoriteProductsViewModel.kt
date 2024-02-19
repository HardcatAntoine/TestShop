package com.assessment.testshop.presentation.screen_favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.assessment.testshop.domain.GetFavoriteProductsCatalogUseCase
import com.assessment.testshop.domain.RemoveFavoriteProductUseCase
import com.assessment.testshop.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteProductsViewModel @Inject constructor(
    private val getFavoriteProductsCatalogUseCase: GetFavoriteProductsCatalogUseCase,
    private val removeFavoriteProductUseCase: RemoveFavoriteProductUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(emptyList<Product>())
    val uiState = _uiState.asStateFlow()

    init {
        getFavoriteProductList()
    }

    private fun getFavoriteProductList() {
        viewModelScope.launch {
            _uiState.update {
                getFavoriteProductsCatalogUseCase.invoke()
            }
        }
    }

    fun removeFavoriteProduct(id: String) {
        viewModelScope.launch {
            removeFavoriteProductUseCase(id)
            getFavoriteProductList()
        }
    }
}