package com.umain.test.fooddelivery.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsResponseDto(val restaurants: List<RestaurantDto>)

@Serializable
data class RestaurantDto(
    val id: String,
    val name: String,
    val rating: Float,
    val filterIds: List<String>,
    @SerialName("image_url") val imageUrl: String,
    @SerialName("delivery_time_minutes") val deliveryTimeInMinutes: Int
)