package com.umain.test.fooddelivery.screens.restaurantslist

import com.umain.test.fooddelivery.screens.ImageSource

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
    val deliveryTime: Int,
    val image: ImageSource
)

data class FilterModel(
    val id: String,
    val name: String,
    val image: ImageSource,
    val isSelected: Boolean,
)