package com.example.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.example.testing.ui.theme.TestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App();
        }
    }
}

@Composable
fun App() {
    TestingTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var name by remember {
                mutableStateOf("")
            }

            var message by remember {
                mutableStateOf("")
            }

            Column {
                Text(text = "Get an emoji in your name for free!!!")

                TextField(modifier = Modifier.testTag("name-textfield"), value = name, onValueChange = { text ->
                    name = text;
                })

                Button(onClick = {
                    message = name + "🎉"
                }) {
                    Text(text = "emojify my name")
                }

                Text(modifier = Modifier.testTag("name-with-emoji"), text = message)
            }
        }
    }
}