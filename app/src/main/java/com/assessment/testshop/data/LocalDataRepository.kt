package com.assessment.testshop.data

import androidx.annotation.WorkerThread
import com.assessment.testshop.data.local.FavoriteProduct
import com.assessment.testshop.data.local.LocalDataDao
import com.assessment.testshop.data.local.Person
import javax.inject.Inject

class LocalDataRepository @Inject constructor(private val dao: LocalDataDao) {
    @WorkerThread
    suspend fun insertPerson(person: Person) {
        dao.insertPerson(person)
    }

    @WorkerThread
    suspend fun getPerson(): Person {
        return dao.getPerson()
    }

    @WorkerThread
    suspend fun insertFavoriteProduct(favoriteProduct: FavoriteProduct) {
        dao.insertFavoriteProduct(favoriteProduct)
    }

    @WorkerThread
    suspend fun removeFavoriteProduct(favoriteProduct: FavoriteProduct): List<FavoriteProduct> {
        dao.removeFavoriteProduct(favoriteProduct)
        return dao.getFavoriteProducts()
    }

    @WorkerThread
    suspend fun getFavoriteProductList(): List<FavoriteProduct> {
        return dao.getFavoriteProducts()
    }
}