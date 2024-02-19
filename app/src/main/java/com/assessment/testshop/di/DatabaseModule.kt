package com.assessment.testshop.di

import android.app.Application
import androidx.room.Room
import com.assessment.testshop.data.ProfileRepository
import com.assessment.testshop.data.local.LocalDataDao
import com.assessment.testshop.data.local.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): LocalDatabase {
        return Room.databaseBuilder(
            application,
            LocalDatabase::class.java,
            "database"
        ).build()
    }

    @Provides
    fun providesLocalDataDao(database: LocalDatabase): LocalDataDao {
        return database.localDataDao()
    }

    @Provides
    fun providesLocalDataRepository(dao: LocalDataDao): ProfileRepository {
        return ProfileRepository(dao)
    }
}