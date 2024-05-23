package com.umain.test.fooddelivery.screens.restaurantslist

import com.umain.test.fooddelivery.network.RemoteClient
import com.umain.test.fooddelivery.screens.BaseViewModel
import com.umain.test.fooddelivery.screens.ImageSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class RestaurantsListViewModel(
    private val remoteClient: RemoteClient
) : BaseViewModel(),
    EventHandler {

    private val _state: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.initialState())

    val state: StateFlow<ScreenState> get() = _state.asStateFlow()

    init {
        loadRestaurantsAndFilters()
    }

    private fun loadRestaurantsAndFilters() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val restaurantsResponse = remoteClient.fetchRestaurants()
            val filters = withContext(Dispatchers.IO) {
                restaurantsResponse.restaurants.flatMap { restaurant ->
                    restaurant.filterIds
                }.distinct().map { filterId ->
                    remoteClient.fetchFilter(filterId)
                }.map {
                    FilterModel(
                        id = it.id,
                        name = it.name,
                        image = ImageSource.Url(it.imageUrl),
                        isSelected = false
                    )
                }
            }

            _state.update { oldState ->
                val restaurants = restaurantsResponse.restaurants.map { res ->
                    RestaurantModel(
                        id = res.id,
                        name = res.name,
                        filters = filters.filter { it.id in res.filterIds },
                        rating = res.rating.toString(),
                        deliveryTime = res.deliveryTimeInMinutes,
                        image = ImageSource.Url(res.imageUrl),
                    )
                }

                oldState.copy(
                    isLoading = false,
                    allFilters = selectFilters(filters, oldState.selectedFilterIds),
                    allRestaurants = restaurants,
                    filteredRestaurants = filterRestaurants(
                        selectedFilterIds = oldState.selectedFilterIds,
                        allRestaurants = restaurants
                    )
                )
            }
        }
    }

    override fun onFilterClicked(id: String) {
        _state.update { old ->
            var selectedIds = old.selectedFilterIds
            selectedIds = if (id in selectedIds) {
                selectedIds - id
            } else {
                selectedIds + id
            }
            old.copy(
                selectedFilterIds = selectedIds,
                allFilters = selectFilters(old.allFilters, selectedIds),
                filteredRestaurants = filterRestaurants(selectedIds, old.allRestaurants)
            )
        }
    }

    private fun filterRestaurants(
        selectedFilterIds: List<String>,
        allRestaurants: List<RestaurantModel>
    ): List<RestaurantModel> =
        if (selectedFilterIds.isEmpty()) {
            allRestaurants
        } else {
            allRestaurants.filter { res ->
                res.filters.map(FilterModel::id).containsAll(selectedFilterIds)
            }
        }

    private fun selectFilters(
        filters: List<FilterModel>,
        selectedIds: List<String>
    ): List<FilterModel> =
        filters.map {
            it.copy(isSelected = it.id in selectedIds)
        }
}