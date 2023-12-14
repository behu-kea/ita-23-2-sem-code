package com.example.basiclayoutexercisesolutions

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basiclayoutexercisesolutions.ui.theme.BasicLayoutExerciseSolutionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutExerciseSolutionsTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Exercise1::class.java);
                        startActivity(intent);
                    }) {
                        Text(text = "navigate to Exercise 1")
                    }

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Exercise2::class.java);
                        startActivity(intent);
                    }) {
                        Text(text = "navigate to Exercise 2")
                    }

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Exercise3::class.java);
                        startActivity(intent);
                    }) {
                        Text(text = "navigate to Exercise 3")
                    }

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Exercise4::class.java);
                        startActivity(intent);
                    }) {
                        Text(text = "navigate to Exercise 4")
                    }

                    Button(onClick = {
                        val intent = Intent(this@MainActivity, Konfetti::class.java);
                        startActivity(intent);
                    }) {
                        Text(text = "🎉")
                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicLayoutExerciseSolutionsTheme {
        Greeting("Android")
    }
}