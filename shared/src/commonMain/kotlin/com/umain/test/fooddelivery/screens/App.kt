package com.umain.test.fooddelivery.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.umain.test.fooddelivery.screens.restaurantslist.RestaurantsListScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App(modifier: Modifier = Modifier) {
    FoodDeliveryAppTheme {
        BottomSheetNavigator {

            Navigator(RestaurantsListScreen())
        }
    }
}