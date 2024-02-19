package com.assessment.testshop.domain.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import com.assessment.testshop.R
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
    val imageRes: Int,
    val isFavorite: Boolean = false
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
        allTags = listOf("all", "face", "body", "suntan", "mask"),
        imageRes = imageResolver(id)
    )
}

fun imageResolver(id: String): Int {
    return when (id) {
        "cbf0c984-7c6c-4ada-82da-e29dc698bb50" -> R.drawable.image_6
        "54a876a5-2205-48ba-9498-cfecff4baa6e" -> R.drawable.image_1
        "75c84407-52e1-4cce-a73a-ff2d3ac031b3" -> R.drawable.image_5
        "16f88865-ae74-4b7c-9d85-b68334bb97db" -> R.drawable.image_3
        "26f88856-ae74-4b7c-9d85-b68334bb97db" -> R.drawable.image_2
        "15f88865-ae74-4b7c-9d81-b78334bb97db" -> R.drawable.image_6
        "88f88865-ae74-4b7c-9d81-b78334bb97db" -> R.drawable.image_4
        "55f58865-ae74-4b7c-9d81-b78334bb97db" -> R.drawable.image_1
        else -> R.drawable.ic_launcher_foreground
    }
}