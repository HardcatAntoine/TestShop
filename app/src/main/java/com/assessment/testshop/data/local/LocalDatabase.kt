package com.assessment.testshop.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class,FavoriteProduct::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun localDataDao(): LocalDataDao
}