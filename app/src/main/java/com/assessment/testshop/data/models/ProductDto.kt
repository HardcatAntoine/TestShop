package com.assessment.testshop.data.models

data class ProductDto(
    val available: Int,
    val description: String,
    val feedback: FeedbackDto,
    val id: String,
    val info: List<InfoDto>,
    val ingredients: String,
    val price: PriceDto,
    val subtitle: String,
    val tags: List<String>,
    val title: String
)