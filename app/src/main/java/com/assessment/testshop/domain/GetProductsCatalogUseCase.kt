package com.assessment.testshop.domain

import com.assessment.testshop.data.ProductsRepository
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.domain.models.toProduct
import javax.inject.Inject

class GetProductsCatalogUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(userId: String = USER_ID): List<Product> {
        return productsRepository
            .getProducts(userId)
            .items
            .map { it.toProduct() }
    }
}