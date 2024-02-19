package com.assessment.testshop.domain

import com.assessment.testshop.data.ProfileRepository
import com.assessment.testshop.data.local.Person
import javax.inject.Inject

class InsertProfileDataUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(firstName: String, lastName: String, phoneNumber: String) {
        profileRepository.insertPerson(Person(null, firstName, lastName, phoneNumber))
    }
}