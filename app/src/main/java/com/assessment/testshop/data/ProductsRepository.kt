package com.assessment.testshop.data

import androidx.annotation.WorkerThread
import com.assessment.testshop.data.local.FavoriteProductId
import com.assessment.testshop.data.local.LocalDataDao
import com.assessment.testshop.data.models.ProductDto
import com.assessment.testshop.data.models.ProductsDto
import com.assessment.testshop.data.remote.MockyApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepository @Inject constructor(
    private val api: MockyApi,
    private val dao: LocalDataDao
) {

    suspend fun getProducts(userId: String): ProductsDto {
        return api.getProducts(userId)
    }
    @WorkerThread
    suspend fun getFavoriteProductIds(): List<FavoriteProductId> {
        return dao.getFavoriteProducts()
    }
    @WorkerThread
    suspend fun insertFavoriteProduct(favoriteProductId: FavoriteProductId) {
        dao.insertFavoriteProduct(favoriteProductId)
    }

    @WorkerThread
    suspend fun removeFavoriteProduct(favoriteProductId: FavoriteProductId): List<FavoriteProductId> {
        dao.removeFavoriteProduct(favoriteProductId)
        return dao.getFavoriteProducts()
    }
}