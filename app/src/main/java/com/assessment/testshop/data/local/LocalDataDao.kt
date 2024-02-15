package com.assessment.testshop.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(person: Person)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteProduct(favoriteProduct: FavoriteProduct)

    @Delete
    suspend fun removeFavoriteProduct(favoriteProduct: FavoriteProduct)

    @Query("SELECT*FROM person")
    suspend fun getPerson(): Person

    @Query("SELECT*FROM `favorite products`")
    suspend fun getFavoriteProducts(): List<FavoriteProduct>
}