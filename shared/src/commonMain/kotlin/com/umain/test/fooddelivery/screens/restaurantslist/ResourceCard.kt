package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.umain.resources.Res
import com.umain.resources.hour
import com.umain.resources.minute
import com.umain.resources.time
import com.umain.test.fooddelivery.screens.goldColor
import io.kamel.image.KamelImage
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun RestaurantCard(
    modifier: Modifier = Modifier,
    model: RestaurantModel,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick(model.id) },
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
    ) {
        KamelImage(
            resource = model.image.load(),
            contentDescription = model.name,
            modifier = Modifier.height(132.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = model.name, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    colorFilter = ColorFilter.tint(goldColor)
                )
                Text(
                    text = model.rating, style = MaterialTheme.typography.labelMedium,
                    color = Color.Black, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            val filters = remember(model) {
                model.filters.map { it.name }
            }

            RestaurantFilters(filters, textStyle = MaterialTheme.typography.labelMedium)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(bottom = 12.dp, top = 4.dp)
            ) {
                Image(
                    imageVector = vectorResource(Res.drawable.time),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Red)
                )

                Text(
                    text = rememberDeliveryTime(model.deliveryTime),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Composable
fun rememberDeliveryTime(deliveryTime: Int): String {
    var time by remember(deliveryTime) { mutableStateOf("") }
    if (time == "") {
        time = calculateTime(deliveryTime)
    }
    return time
}

@Composable
fun calculateTime(timeInMinutes: Int): String {
    var result = ""
    val hours = timeInMinutes / 60
    val minutes = timeInMinutes % 60

    if (hours > 0) {
        result += pluralStringResource(Res.plurals.hour, hours, hours)
    }

    if (minutes > 0) {
        result += " "
        result += pluralStringResource(Res.plurals.minute, minutes, minutes)
    }
    return result
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RestaurantFilters(
    filters: List<String>,
    textStyle: TextStyle
) {
    FlowRow {
        filters.fastForEach { filter ->
            Text(text = filter, style = textStyle)
            if (filter != filters.last()) {
                Text(text = " • ", style = textStyle)
            }
        }
    }
}
