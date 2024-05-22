package com.umain.test.fooddelivery.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal interface RemoteClient {
    suspend fun fetchRestaurants(): RestaurantsResponseDto
    suspend fun fetchFilter(id: String): FilterResponseDto
    suspend fun fetchIsRestaurantOpen(id: String): IsRestaurantOpenResponseDto

    fun url(path: String): String = "${BASE_URL}/${path}"

    companion object {
        internal const val BASE_URL = "https://food-delivery.umain.io/api/v1"

        fun instance(): RemoteClient = RemoteClientImpl
    }
}

private val client = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            useAlternativeNames = false
        })
    }
}

private object RemoteClientImpl : RemoteClient {
    override suspend fun fetchRestaurants(): RestaurantsResponseDto {
        return client.get(url("restaurants")).body()
    }

    override suspend fun fetchFilter(id: String): FilterResponseDto {
        return client.get(url("filter/${id}")).body()
    }

    override suspend fun fetchIsRestaurantOpen(id: String): IsRestaurantOpenResponseDto {
        return client.get(url("open/${id}")).body()
    }
}