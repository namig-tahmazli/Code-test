package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.umain.test.fooddelivery.network.RemoteClient

class RestaurantsListScreen : Screen {
    @Composable
    override fun Content() {
        val model = rememberScreenModel { RestaurantsListViewModel(RemoteClient.instance()) }
        val state = model.state.collectAsState()
        RestaurantsListView(state = state.value, eventHandler = model,
            modifier = Modifier)
    }
}

