package com.tomildev.weathy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tomildev.features.mainview.presentation.MainViewScreen
import com.tomildev.weathy.ui.theme.WeathyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeathyTheme {
                MainViewScreen()
            }
        }
    }
}