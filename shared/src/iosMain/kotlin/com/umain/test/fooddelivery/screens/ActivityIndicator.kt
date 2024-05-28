package com.umain.test.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIActivityIndicatorView
import platform.UIKit.UIActivityIndicatorViewStyleMedium

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ActivityIndicator(
    modifier: Modifier
) {
    UIKitView(
        modifier = modifier,
        factory = {
            val indicator = UIActivityIndicatorView()
            indicator.setActivityIndicatorViewStyle(UIActivityIndicatorViewStyleMedium)
            indicator.color = greenColor.toUIColor()
            indicator.startAnimating()
            indicator
        },
        onResize = { indicator, rect ->
            indicator.setFrame(rect)
        }
    )
}