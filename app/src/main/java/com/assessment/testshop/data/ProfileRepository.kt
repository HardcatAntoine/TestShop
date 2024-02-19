package com.assessment.testshop.data

import androidx.annotation.WorkerThread
import com.assessment.testshop.data.local.LocalDataDao
import com.assessment.testshop.data.local.Person
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val dao: LocalDataDao) {
    @WorkerThread
    suspend fun insertPerson(person: Person) {
        dao.insertPerson(person)
    }

    @WorkerThread
    suspend fun getPerson(): Person? {
        return dao.getPerson()
    }
}