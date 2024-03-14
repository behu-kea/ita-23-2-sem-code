package com.example.navigation_medito

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation_medito.models.Topic
import com.example.navigation_medito.ui.theme.NavigationmeditoTheme
import com.example.navigation_medito.viewmodels.MeditoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val meditoViewModel = viewModel<MeditoViewModel>();
            NavigationmeditoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    Column {
                        NavHost(navController = navController, startDestination = "screen1") {
                            composable("screen1") {
                                LazyColumn {
                                    items(items = meditoViewModel.topics) { topic ->
                                        Text(text = topic.title)
                                        Button(onClick = {
                                            navController.navigate("sendArgumentsHere/${topic.title}")
                                        }) {
                                            Text(text = "Go to Topic")
                                        }
                                    }
                                }
                            }

                            composable("sendArgumentsHere/{title}", arguments = listOf(navArgument("title") {})) { backStackEntry ->
                                val title = backStackEntry.arguments?.getString("title") ?: return@composable
                                Log.d("LOL", title);
                                var foundTopic = meditoViewModel.topics.filter({topic -> topic.title == title})[0]
                                Column {
                                    Text(text = foundTopic.title)
                                    Text(text = foundTopic.description)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
