package com.assessment.testshop.presentation.screen_product_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.testshop.domain.GetProductByIdUseCase
import com.assessment.testshop.domain.PRODUCT_ID
import com.assessment.testshop.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getProductById: GetProductByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Product?>(null)
    val uiState = _uiState.asStateFlow()

    init {
        getProduct()
    }

    private fun getProduct() {
        val productId = savedStateHandle.get<String>(PRODUCT_ID)
        if (productId.isNullOrEmpty()) {
            Log.d("NAV_ARGS", "PRODUCT ID = $productId")
        } else {
            viewModelScope.launch {
                _uiState.update { getProductById(productId) }
            }
        }
    }
}