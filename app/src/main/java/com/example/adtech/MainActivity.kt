package com.example.adtech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.adtech.ui.theme.AdTechTheme
import com.example.sdkad.SDKInitializer
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SDKInitializer.initSdk(this, UUID.randomUUID())
        enableEdgeToEdge()
        setContent {

            AdTechTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SDKInitializer.DisplayFulScreenAd(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}