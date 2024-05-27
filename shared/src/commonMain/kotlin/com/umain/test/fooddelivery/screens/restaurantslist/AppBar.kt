package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.umain.resources.Res
import com.umain.resources.logo
import org.jetbrains.compose.resources.vectorResource

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Image(
            imageVector = vectorResource(Res.drawable.logo),
            contentDescription = "Logo"
        )
    }
}