package com.example.navigation

import android.os.Bundle
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val information by remember {
                mutableStateOf( mutableMapOf<String, Int>("price1" to 6));
            }

            val navController = rememberNavController()
            Column {
                Text(text = "asd")
                NavHost(navController = navController, startDestination = "screen1") {
                    composable("screen1") {
                        Screen1("benjamin",
                            onNavigate = {
                            information["price2"] = 2;
                            navController.navigate("screen2")
                            println(navController.currentBackStackEntry)
                        }, onToArguments = {
                            navController.navigate("sendArgumentsHere/Benjamin")
                        })
                    }
                    composable("screen2") {
                        Screen2(id = 2, onNavigate = {
                            information["price3"] = 5;
                            navController.navigate("screen3")
                            println(navController.currentBackStackEntry)
                        })
                    }
                    composable("screen3") {
                        Screen3(information, onBackToStart = {
                            navController.popBackStack("screen1", false);
                            println(navController.currentBackStackEntry)
                        })
                    }
                    composable("sendArgumentsHere/{name}", arguments = listOf(navArgument("name") {})) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: return@composable
                        SendArgumentsHere(name)
                    }
                }
            }
        }
    }
}

@Composable
fun Screen1(name: String, onNavigate: ()-> Unit, onToArguments: () -> Unit) {
    Column {
        Text(
            text = "Screen 1",
            fontSize = 32.sp
        )
        Text(
            text = "Hello $name!"
        )
        Button(onClick = onNavigate) {
            Text("Go to Screen 2")
        }
        Button(onClick = onToArguments) {
            Text("To arguments screen")
        }
    }
}

@Composable
fun Screen2( id: Int, onNavigate: () -> Unit) {
    Column {
        Text(
            text = "Screen 2!",
            fontSize = 32.sp
        )
        Button(onClick = onNavigate) {
            Text(text = "Go to screen 3")
        }
    }
}

@Composable
fun Screen3(status: MutableMap<String, Int>, onBackToStart: () -> Unit) {
    Column {
        Text(
            text = "Screen 3",
            fontSize = 32.sp
        )
        Text(
            text = "We are at ${status["price1"]}, ${status["price2"]}, , ${status["price3"]}!!!"
        )
        Button(onClick = onBackToStart) {
            Text(text = "Back to start");
        }
    }
}

@Composable
fun SendArgumentsHere(name: String) {
    Text(text = name)
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Klik på knappen")
    }
}

