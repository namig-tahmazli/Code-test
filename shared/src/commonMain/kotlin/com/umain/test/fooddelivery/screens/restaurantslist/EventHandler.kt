package com.umain.test.fooddelivery.screens.restaurantslist

interface EventHandler {
    fun onFilterClicked(id: String)
    fun onRestaurantClicked(id: String)
}