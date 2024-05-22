package com.umain.test.fooddelivery.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodDeliveryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF1F2B2E),
            secondary = Color(0xFF1F2B2E),
            tertiary = Color(0xFF1F2B2E),
            background = Color(0xFF1F2B2E),
            onBackground = Color(0xFFFFFFF),
        )
    } else {
        lightColorScheme(
            primary = Color(0xFFFFFF),
            secondary = Color(0xFFFFFF),
            tertiary = Color(0xFFFFFF),
            background = Color(0xFFFFFF),
            onBackground = Color(0xFF1F2B2E)
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W400,
            fontSize = 18.sp
        ),
        labelMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
            color = Color(0xff999999),
        ),
        labelLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color(0xff999999),
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontSize = 12.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W400,
            fontSize = 22.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

val goldColor = Color(0xFFF9CA24)
