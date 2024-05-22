package com.umain.test.fooddelivery.screens.restaurantdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import com.umain.test.fooddelivery.network.RemoteClient
import com.umain.test.fooddelivery.screens.restaurantslist.RestaurantModel

class RestaurantDetailsScreen(private val restaurant: RestaurantModel) : Screen {
    @Composable
    override fun Content() {
        val viewModel = remember {
            RestaurantDetailsViewModel(
                remoteClient = RemoteClient.instance(),
                restaurant,
            )
        }
        RestaurantDetailsView(model = viewModel)
    }
}