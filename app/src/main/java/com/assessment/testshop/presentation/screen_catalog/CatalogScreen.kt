package com.assessment.testshop.presentation.screen_catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assessment.testshop.R
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.presentation.theme.DisabledButton
import com.assessment.testshop.presentation.theme.EnabledButton
import com.assessment.testshop.presentation.theme.RatingText

@Composable
fun CatalogScreen(onItemClick: (String) -> Unit) {
    val viewModel: CatalogViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    CatalogScreenContent(
        uiState,
        onItemClick = { onItemClick(it.id)},
        onFavoriteClick = {/*TODO*/ },
        onAddToCartClick = {/*TODO*/ },
        onFilterChipClick = { filterTag -> viewModel.filterProducts(filterTag) },
    )
}

@Composable
fun CatalogScreenContent(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    onFavoriteClick: (Product) -> Unit,
    onAddToCartClick: (Product) -> Unit,
    onFilterChipClick: (String) -> Unit,
) {
    Column {
        if (products.isNotEmpty()) {
            FilterChipGroup(
                products.first().allTags,
                onChipClick = { tag -> onFilterChipClick(tag) }
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
        ) {
            items(products) { product ->
                ProductsCatalogItem(
                    product = product,
                    onItemClick = { onItemClick(it) },
                    onFavoriteClick = { onFavoriteClick(it) },
                    onAddToCartClick = { onAddToCartClick(it) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsCatalogItem(
    product: Product,
    onItemClick: (Product) -> Unit,
    onFavoriteClick: (Product) -> Unit,
    onAddToCartClick: (Product) -> Unit,
) {
    Card(
        modifier = Modifier
            .size(width = 168.dp, height = 287.dp)
            .padding(4.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = { onItemClick(product) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
                .background(Color.White),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = product.imageRes),
                contentDescription = "Product Image"
            )
            IconButton(
                onClick = { onFavoriteClick(product) },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_half_favorite),
                    contentDescription = "Favorite button",
                    tint = EnabledButton
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(start = 8.dp)
            ) {
                Icon(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.pagination),
                    contentDescription = "pagination"
                )
                Box(modifier = Modifier.padding(top = 2.dp)) {
                    Text(
                        text = "${product.price.priceWithDiscount} ${product.price.unit}",
                        fontSize = 9.sp,
                    )
                    Image(
                        modifier = Modifier.padding(top = 4.dp),
                        painter = painterResource(id = R.drawable.discount_line),
                        contentDescription = "discount_line"
                    )
                }

                Text(
                    text = "${product.price.price} ${product.price.unit}",
                    fontSize = 14.sp
                )
                Text(
                    text = product.title,
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier
                        .height(37.dp)
                        .padding(end = 8.dp),
                    text = product.subtitle,
                    fontSize = 10.sp,
                    maxLines = 3,
                    style = MaterialTheme.typography.bodySmall,
                    lineHeight = 10.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.star_filled),
                        contentDescription = "Feedback score icon",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(text = "${product.feedback.rating}", fontSize = 9.sp, color = RatingText)
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(text = "(${product.feedback.count})", fontSize = 9.sp)
                }
            }
            Image(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable { onAddToCartClick(product) }
                    .size(32.dp),
                painter = painterResource(id = R.drawable.add_product_button),
                contentDescription = "Add to cart button"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipGroup(
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    onChipClick: (String) -> Unit,
) {
    var selectedItemIndex by remember { mutableIntStateOf(defaultSelectedItemIndex) }

    LazyRow(userScrollEnabled = true) {
        items(items.size) { index: Int ->
            FilterChip(
                modifier = Modifier.padding(horizontal = 12.dp),
                selected = items[selectedItemIndex] == items[index],
                onClick = {
                    selectedItemIndex = index
                    onChipClick(items[selectedItemIndex])
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Filter chip icon"
                    )
                },
                label = { Text(items[index]) },
            )
        }
    }
}