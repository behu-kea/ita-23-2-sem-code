package com.example.basiclayoutexercisesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Exercise4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Header1()
                Products()
                Spacer(Modifier.weight(1f, fill = true))
            }
            Trolley()
        }
    }
}

@Composable
fun Header1() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Køb køb køb",
            fontSize = 32.sp
        )
    }
    Divider (
        color = Color.Black,
        modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Products() {
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        Product()
        Product()
        Product()
        Product()
        Product()
        Product()
        Product()
        Product()
    }
}

@Composable
fun Product() {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_image), // Replace 'my_image' with your image file name without the extension
            contentDescription = "Description for accessibility", // Provide a description for accessibility
            modifier = Modifier
                .size(100.dp)
                .padding(end = 12.dp)
        )
        Text(
            text = "Benjamin ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin, ligula quis fermentum pulvinar",
            modifier = Modifier.weight(1f)
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "+")
        }

    }
    Divider (
        color = Color.Black,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Trolley() {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(32.dp)
        ) {
            Text("🛒")
        }
    }
}