package com.umain.test.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreGraphics.CGAffineTransformMakeScale
import platform.UIKit.UIActivityIndicatorView
import platform.UIKit.UIActivityIndicatorViewStyleGray

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ActivityIndicator(
    modifier: Modifier
) {
    UIKitView(
        modifier = modifier,
        factory = {
            val indicator = UIActivityIndicatorView()
            indicator.setActivityIndicatorViewStyle(UIActivityIndicatorViewStyleGray)
            indicator.color = greenColor.toUIColor()
            indicator.transform = CGAffineTransformMakeScale(sx = 2.0, sy = 2.0)
            indicator.startAnimating()
            indicator
        },
    )
}