package com.example.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nav.ui.theme.NavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Column {

                            Text(text = "home")
                            Button(onClick = {
                                navController.navigate("downloads")
                            }) {
                                Text(text = "Go to download")
                            }
                        }
                    }
                    composable("downloads") {
                        Text(text = "Downloads")
                        Button(onClick = { navController.popBackStack() }) {
                            Text(text = "Go back")
                        }
                        
                        Button(onClick = {
                            navController.navigate("renderName/Benmjamin")
                        }) {
                            Text(text = "send data to other screen")
                        }
                    }

                    composable("renderName/{name}", arguments = listOf(navArgument("name") { type = NavType.StringType })) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: return@composable
                        Text(text = name)
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
    NavTheme {
        Greeting("Android")
    }
}