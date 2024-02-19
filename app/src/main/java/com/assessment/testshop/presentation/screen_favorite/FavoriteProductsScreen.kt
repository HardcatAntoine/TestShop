package com.assessment.testshop.presentation.screen_favorite

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.presentation.screen_catalog.ProductsCatalogItem

@Composable
fun FavoriteProductsScreen(onItemClick: (String) -> Unit) {
    val viewModel: FavoriteProductsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    FavoriteProductsScreenContent(
        products = uiState,
        onItemClick = {onItemClick(it.id)},
        onAddFavorite = {},
        onRemoveFavorite = { viewModel.removeFavoriteProduct(it.id) },
        onAddToCartClick = {}
    )
}

@Composable
fun FavoriteProductsScreenContent(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    onAddFavorite: (Product) -> Unit,
    onRemoveFavorite: (Product) -> Unit,
    onAddToCartClick: (Product) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(products) { product ->
            ProductsCatalogItem(
                product = product,
                onItemClick = { onItemClick(it) },
                onAddFavorite = { onAddFavorite(it) },
                onRemoveFavorite = { onRemoveFavorite(it) },
                onAddToCartClick = { onAddToCartClick(it) }
            )
        }
    }
}
