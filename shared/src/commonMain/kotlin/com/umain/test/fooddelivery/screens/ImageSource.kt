package com.umain.test.fooddelivery.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import io.kamel.core.Resource
import io.kamel.image.asyncPainterResource

sealed interface ImageSource {
    val data: Any
    data class Url(override val data: String) : ImageSource
    data class Local(override val data: Int) : ImageSource

    @Composable
    fun load() : Resource<Painter> {
        return asyncPainterResource(data)
    }
}