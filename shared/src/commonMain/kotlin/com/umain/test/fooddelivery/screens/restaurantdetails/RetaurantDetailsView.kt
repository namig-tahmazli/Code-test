package com.umain.test.fooddelivery.screens.restaurantdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.umain.resources.Res
import com.umain.resources.chevron_down
import com.umain.resources.closed
import com.umain.resources.open
import com.umain.test.fooddelivery.screens.ActivityIndicator
import com.umain.test.fooddelivery.screens.FoodDeliveryAppTheme
import com.umain.test.fooddelivery.screens.restaurantslist.RestaurantFilters
import io.kamel.image.KamelImage
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun RestaurantDetailsView(
    modifier: Modifier = Modifier,
    state: ScreenState
) {
    val navigator = LocalBottomSheetNavigator.current
    FoodDeliveryAppTheme {
        Scaffold { edges ->
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                KamelImage(
                    resource = state.restaurant.image.load(),
                    modifier = Modifier.fillMaxWidth().height(220.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                CloseButton(
                    navigator,
                    Modifier.padding(
                        top = edges.calculateTopPadding() + 8.dp,
                        start = edges.calculateStartPadding(LayoutDirection.Ltr) + 4.dp
                    )
                )

                RestaurantInfoCard(state)
            }
        }
    }
}

@Composable
private fun CloseButton(
    navigator: BottomSheetNavigator,
    modifier: Modifier
) {
    IconButton(
        onClick = { navigator.hide() }, modifier = modifier.size(48.dp)
    ) {
        Icon(
            imageVector = vectorResource(Res.drawable.chevron_down),
            contentDescription = "Close Button",
            tint = Color.Black,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
private fun RestaurantInfoCard(
    state: ScreenState
) {
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
            .padding(top = 180.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 24.dp
            ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(state.restaurant.name, style = MaterialTheme.typography.headlineMedium)
            val filters = remember(state.restaurant) {
                state.restaurant.filters.map { it.name }
            }
            RestaurantFilters(filters, textStyle = MaterialTheme.typography.labelLarge)

            if (state.isOpen != null) {
                Text(
                    if (state.isOpen) {
                        stringResource(Res.string.open)
                    } else {
                        stringResource(Res.string.closed)
                    }, color = Color(0xff2ECC71)
                )
            }

            if (state.isLoading) {
                ActivityIndicator(Modifier.size(24.dp))
            }
        }
    }
}