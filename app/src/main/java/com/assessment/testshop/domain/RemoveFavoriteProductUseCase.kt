package com.assessment.testshop.domain

import com.assessment.testshop.data.ProductsRepository
import com.assessment.testshop.data.local.FavoriteProductId
import javax.inject.Inject

class RemoveFavoriteProductUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(id: String) {
        productsRepository.removeFavoriteProduct(FavoriteProductId(id))
    }
}