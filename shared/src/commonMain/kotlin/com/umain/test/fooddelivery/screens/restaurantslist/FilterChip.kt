package com.umain.test.fooddelivery.screens.restaurantslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    model: FilterModel,
    onClicked: (String) -> Unit
) {
    Card(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp),
        onClick = { onClicked(model.id) },
        shape = RoundedCornerShape(50),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = if (model.isSelected) Color(0xffc6d9f7) else Color.White
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            KamelImage(
                resource = model.image.load(),
                contentDescription = model.name,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Text(
                text = model.name, modifier = Modifier.padding(start = 8.dp, end = 12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}