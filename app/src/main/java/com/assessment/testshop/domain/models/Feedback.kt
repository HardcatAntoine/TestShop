package com.assessment.testshop.domain.models

import com.assessment.testshop.data.models.FeedbackDto

data class Feedback(
    val count: Int,
    val rating: Double
)

fun FeedbackDto.toFeedback(): Feedback {
    return Feedback(count, rating)
}