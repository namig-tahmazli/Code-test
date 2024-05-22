package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import io.kamel.core.Resource

data class ScreenState(
    val isLoading: Boolean,
    val allFilters: List<FilterModel>,
    val allRestaurants: List<RestaurantModel>,
    val selectedFilterIds: List<String>,
    val filteredRestaurants: List<RestaurantModel>
) {
    companion object {
        fun initialState(): ScreenState = ScreenState(
            isLoading = true,
            allFilters = emptyList(),
            allRestaurants = emptyList(),
            selectedFilterIds = emptyList(),
            filteredRestaurants = emptyList()
        )
    }
}

data class RestaurantModel(
    val id: String,
    val name: String,
    val filters: List<FilterModel>,
    val rating: String,
    val deliveryTime: @Composable () -> String,
    val image: @Composable () -> Resource<Painter>
)

data class FilterModel(
    val id: String,
    val name: String,
    val imageUrl: String,
    val isSelected: Boolean
)