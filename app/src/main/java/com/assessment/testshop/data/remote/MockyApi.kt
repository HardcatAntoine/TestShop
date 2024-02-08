package com.assessment.testshop.data.remote

import com.assessment.testshop.data.models.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MockyApi {

    @GET("{user_id}")
    suspend fun getProducts(@Path("user_id") userId: String): ProductsDto
}