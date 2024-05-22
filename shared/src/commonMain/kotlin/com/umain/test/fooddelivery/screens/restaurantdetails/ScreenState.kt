package com.umain.test.fooddelivery.screens.restaurantdetails

import com.umain.test.fooddelivery.screens.restaurantslist.RestaurantModel

data class ScreenState(
    val isLoading: Boolean,
    val restaurant: RestaurantModel,
    val isOpen: Boolean?
) {
    companion object {
        fun initialState(restaurant: RestaurantModel): ScreenState =
            ScreenState(
                isLoading = true,
                restaurant = restaurant,
                isOpen = null,
            )
    }
}