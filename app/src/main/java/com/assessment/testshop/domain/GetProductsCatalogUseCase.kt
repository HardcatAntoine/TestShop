package com.assessment.testshop.domain

import com.assessment.testshop.data.ProductsRepository
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.domain.models.toProduct
import javax.inject.Inject

class GetProductsCatalogUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(userId: String = USER_ID): List<Product> {
        val dtoProducts = productsRepository.getProducts(userId).items
        val products = dtoProducts.map { it.toProduct() }

        val favoriteIds = productsRepository.getFavoriteProductIds()

        val result = products.map { product ->
            if (favoriteIds.any { it.id == product.id }) {
                product.copy(isFavorite = true)
            } else {
                product
            }
        }

        return result
    }
}