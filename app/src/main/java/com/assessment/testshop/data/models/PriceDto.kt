package com.assessment.testshop.data.models

data class PriceDto(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)