package com.assessment.testshop.domain.models

import com.assessment.testshop.data.models.InfoDto

data class Info(
    val title: String,
    val value: String
)

fun InfoDto.toInfo(): Info {
    return Info(title, value)
}