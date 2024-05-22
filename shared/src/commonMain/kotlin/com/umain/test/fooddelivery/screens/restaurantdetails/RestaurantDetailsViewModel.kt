package com.umain.test.fooddelivery.screens.restaurantdetails

import com.umain.test.fooddelivery.network.RemoteClient
import com.umain.test.fooddelivery.screens.BaseViewModel
import com.umain.test.fooddelivery.screens.restaurantslist.RestaurantModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class RestaurantDetailsViewModel(
    private val remoteClient: RemoteClient,
    private val restaurant: RestaurantModel,
) : BaseViewModel() {
    private val _state: MutableStateFlow<ScreenState> = MutableStateFlow(
        ScreenState.initialState(restaurant)
    )

    val state: StateFlow<ScreenState> = _state.asStateFlow()

    init {
        checkRestaurantOpen()
    }

    private fun checkRestaurantOpen() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val response = remoteClient.fetchIsRestaurantOpen(restaurant.id)
            _state.update { old ->
                old.copy(
                    isLoading = false,
                    isOpen = response.isOpen
                )
            }
        }
    }
}