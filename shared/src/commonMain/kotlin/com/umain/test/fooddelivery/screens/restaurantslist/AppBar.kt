package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.umain.resources.Res
import com.umain.resources.logo
import org.jetbrains.compose.resources.vectorResource

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    logo: ImageVector = vectorResource(Res.drawable.logo)
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 44.dp, start = 16.dp)
    ) {
        Image(
            imageVector = logo,
            contentDescription = "Logo"
        )
    }
}