package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.umain.resources.Res
import com.umain.resources.logo
import com.umain.resources.time
import org.jetbrains.compose.resources.vectorResource

data class LocalImages(
    val logo: ImageVector,
    val time: ImageVector,
) {
    companion object {
        @Composable
        fun compose(): LocalImages = LocalImages(
            logo = vectorResource(Res.drawable.logo),
            time = vectorResource(Res.drawable.time)
        )
    }
}