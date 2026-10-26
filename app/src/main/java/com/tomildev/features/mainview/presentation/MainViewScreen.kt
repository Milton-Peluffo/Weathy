package com.tomildev.features.mainview.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.WeathyDrawables

@Composable
fun MainViewScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(Dimens.ScreenHorizontalPadding)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                Icon(
                    painter = painterResource(WeathyDrawables.Icons.ClearSky),
                    contentDescription = null
                )
                Texts
            }
        }

    }
}