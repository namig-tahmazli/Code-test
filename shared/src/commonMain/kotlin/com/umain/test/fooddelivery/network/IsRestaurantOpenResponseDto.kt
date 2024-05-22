package com.umain.test.fooddelivery.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IsRestaurantOpenResponseDto(
    @SerialName("restaurant_id") val restaurantId: String,
    @SerialName("is_currently_open") val isOpen: Boolean
)