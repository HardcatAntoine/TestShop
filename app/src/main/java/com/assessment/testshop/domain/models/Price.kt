package com.assessment.testshop.domain.models

import com.assessment.testshop.data.models.PriceDto

data class Price(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)

fun PriceDto.toPrice(): Price {
    return Price(
        discount,
        price,
        priceWithDiscount,
        unit
    )
}