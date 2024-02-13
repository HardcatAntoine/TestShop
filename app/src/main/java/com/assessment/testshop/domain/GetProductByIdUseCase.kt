package com.assessment.testshop.domain

import com.assessment.testshop.data.ProductsRepository
import com.assessment.testshop.domain.models.Product
import com.assessment.testshop.domain.models.toProduct
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(productId: String): Product? {
        val list = productsRepository
            .getProducts(userId = USER_ID)
            .items
            .map { it.toProduct() }
        return list.find { it.id == productId }
    }
}