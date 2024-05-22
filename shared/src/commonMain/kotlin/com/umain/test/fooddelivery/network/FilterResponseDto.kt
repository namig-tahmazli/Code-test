package com.umain.test.fooddelivery.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilterResponseDto(
    val id: String,
    val name: String,
    @SerialName("image_url") val imageUrl: String
)
