package com.assessment.testshop.domain

import com.assessment.testshop.data.ProductsRepository
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.domain.models.toProduct
import javax.inject.Inject

class FilterCatalogUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(filterTag: String): List<Product> {
        return if (filterTag == "all") {
            productsRepository
                .getProducts(userId = USER_ID)
                .items
                .map { it.toProduct() }
        } else {
            productsRepository
                .getProducts(userId = USER_ID)
                .items
                .map { it.toProduct() }
                .filter { product -> product.tags.contains(filterTag) }
        }
    }
}