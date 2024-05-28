package com.umain.test.fooddelivery.screens

import androidx.compose.ui.graphics.Color
import platform.UIKit.UIColor

fun Color.toUIColor(): UIColor {
    return UIColor(
        red = red.toDouble(),
        green = green.toDouble(),
        blue = blue.toDouble(),
        alpha = alpha.toDouble()
    )
}