package com.assessment.testshop.presentation.screen_catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.testshop.domain.FilterCatalogUseCase
import com.assessment.testshop.domain.GetProductsCatalogUseCase
import com.assessment.testshop.domain.InsertFavoriteProductUseCase
import com.assessment.testshop.domain.RemoveFavoriteProductUseCase
import com.assessment.testshop.domain.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val insertFavoriteProductUseCase: InsertFavoriteProductUseCase,
    private val removeFavoriteProductUseCase: RemoveFavoriteProductUseCase,
    private val getProductsCatalog: GetProductsCatalogUseCase,
    private val filterCatalogUseCase: FilterCatalogUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(emptyList<Product>())
    val uiState = _uiState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { getProductsCatalog() }
        }
    }

    fun filterProducts(filterTag: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _uiState.update { filterCatalogUseCase(filterTag) }
        }
    }

    fun addToFavorite(id: String) {
        viewModelScope.launch {
            insertFavoriteProductUseCase(id)
            getProducts()
        }
    }

    fun removeFavorite(id: String) {
        viewModelScope.launch {
            removeFavoriteProductUseCase(id)
            getProducts()
        }
    }

}