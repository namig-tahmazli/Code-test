package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.umain.test.fooddelivery.screens.FoodDeliveryAppTheme
import com.umain.test.fooddelivery.screens.restaurantdetails.RestaurantDetailsScreen
import io.kamel.image.asyncPainterResource

@Composable
fun RestaurantsListView(
    modifier: Modifier = Modifier,
    localImages: LocalImages = LocalImages.compose(),
    state: ScreenState,
    eventHandler: EventHandler
) {
    val navigator = LocalBottomSheetNavigator.current

    FoodDeliveryAppTheme {
        Scaffold(
            topBar = { AppBar(logo = localImages.logo) },
            modifier = modifier.background(Color.White)
        ) {

            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                        color = Color(0xff2ECC71)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.padding(it).fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    LazyRow(
                        modifier = Modifier.wrapContentHeight().fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        itemsIndexed(state.allFilters) { index, filter ->
                            FilterChip(
                                painter = asyncPainterResource(data = filter.imageUrl),
                                title = filter.name,
                                id = filter.id,
                                onClicked = eventHandler::onFilterClicked,
                                modifier = Modifier.padding(
                                    start = if (index == 0) 8.dp else 0.dp
                                ),
                                isSelected = filter.isSelected
                            )
                        }
                    }
                }
                items(state.filteredRestaurants) { restaurant ->
                    RestaurantCard(
                        image = restaurant.image(),
                        model = restaurant,
                        onClick = { navigator.show(RestaurantDetailsScreen(restaurant)) },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}
