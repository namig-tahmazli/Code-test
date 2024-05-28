package com.umain.test.fooddelivery.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun ActivityIndicator(modifier: Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = greenColor
    )
}