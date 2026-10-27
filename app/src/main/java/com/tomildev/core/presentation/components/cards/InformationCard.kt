package com.tomildev.core.presentation.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tomildev.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.core.presentation.components.texts.Texts
import com.tomildev.weathy.ui.theme.Dimens

@Composable
fun InformationCard(icon: Int, iconColor: Color, data: String, dataDescription: String) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 25.dp, vertical = 13.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier
                        .padding(end = Dimens.SpacingTiny)
                        .size(Dimens.IconSizeNormal),
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = iconColor
                )
                Texts.Body(text = data, fontWeight = FontWeight.Bold)
            }
            VerticalSpacer(Dimens.SpacingTiny)
            Texts.BodySmall(text = dataDescription, isSecondary = true)
        }
    }
}