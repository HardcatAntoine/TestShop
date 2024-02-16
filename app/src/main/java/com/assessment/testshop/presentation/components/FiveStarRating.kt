package com.assessment.testshop.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.assessment.testshop.R
import com.assessment.testshop.presentation.theme.RatingText

enum class Rating(val icon: Int) {
    EMPTY_STAR(R.drawable.star_empty),
    HALF_STAR(R.drawable.star_half),
    FULL_STAR(R.drawable.star_filled)
}

fun getHalfOrEmptyStar(rating: Double): Int {
    return if (rating.rem(1.0) >= 0.5) Rating.HALF_STAR.icon else Rating.EMPTY_STAR.icon
}

@Composable
fun FiveStarRating(rating: Double) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        (1..5).forEach { index ->
            val starIcon = if (index <= rating) Rating.FULL_STAR.icon else getHalfOrEmptyStar(rating)
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = starIcon),
                contentDescription = "Rating",
                tint = RatingText
            )
        }
    }
}
