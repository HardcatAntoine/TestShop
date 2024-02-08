package com.assessment.testshop.data

import com.assessment.testshop.data.models.ProductDto
import com.assessment.testshop.data.models.ProductsDto
import com.assessment.testshop.data.remote.MockyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor(
    private val api: MockyApi,
) {

    suspend fun getProducts(userId: String): ProductsDto {
        return api.getProducts(userId)
    }
}