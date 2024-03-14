package com.example.async_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.async_learning.ui.theme.AsynclearningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    // Declare the state at class level to make it accessible inside callAsync
    private var isGreen by mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsynclearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Use isGreen state directly here
                    if(isGreen) {
                        Text(text = "Green", modifier = Modifier.background(Color.Green))
                    } else {
                        Text(text = "Red", modifier = Modifier.background(Color.Red))
                    }
                }
            }
        }
        callAsync()
    }

    private val scope = CoroutineScope(Dispatchers.Main)

    private fun callAsync() {
        scope.launch {
            run()
        }
    }

    private suspend fun run() {
        delay(1000)
        // Toggle the isGreen state after delay
        isGreen = !isGreen
    }
}
