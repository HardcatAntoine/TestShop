package com.assessment.testshop.domain.models

import com.assessment.testshop.data.models.ProductDto

data class Product(
    val available: Int,
    val description: String,
    val feedback: Feedback,
    val id: String,
    val info: List<Info>,
    val ingredients: String,
    val price: Price,
    val subtitle: String,
    val tags: List<String>,
    val title: String,
    val allTags: List<String>,
)

fun ProductDto.toProduct(): Product {
    return Product(
        available = available,
        description = description,
        feedback = feedback.toFeedback(),
        id = id,
        info = info.map { it.toInfo() },
        ingredients = ingredients,
        price = price.toPrice(),
        subtitle = subtitle,
        tags = tags,
        title = title,
        allTags = listOf("all", "face", "body", "suntan", "mask")
    )
}