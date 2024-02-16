package com.assessment.testshop.domain

import com.assessment.testshop.data.ProfileRepository
import com.assessment.testshop.data.local.Person
import javax.inject.Inject

class GetProfileDataUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Person? {
       return profileRepository.getPerson()
    }
}