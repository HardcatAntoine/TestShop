package com.assessment.testshop.data

import androidx.annotation.WorkerThread
import com.assessment.testshop.data.local.FavoriteProductId
import com.assessment.testshop.data.local.LocalDataDao
import com.assessment.testshop.data.local.Person
import javax.inject.Inject

class LocalDataRepository @Inject constructor(private val dao: LocalDataDao) {
    @WorkerThread
    suspend fun insertPerson(person: Person) {
        dao.insertPerson(person)
    }

    @WorkerThread
    suspend fun getPerson(): Person? {
        return dao.getPerson()
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