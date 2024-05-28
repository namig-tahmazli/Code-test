package com.umain.test.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.layout.onSizeChanged
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIActivityIndicatorView
import platform.UIKit.UIActivityIndicatorViewStyleMedium

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ActivityIndicator(
    modifier: Modifier
) {
    var currentSize by remember { mutableStateOf(Size.Zero) }
    UIKitView(
        modifier = modifier.onSizeChanged {
            currentSize = Size(it.width.toFloat(), it.height.toFloat())
        },
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