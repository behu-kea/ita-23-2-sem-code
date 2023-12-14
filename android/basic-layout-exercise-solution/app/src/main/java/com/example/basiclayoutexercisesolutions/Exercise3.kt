package com.example.basiclayoutexercisesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Exercise3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Header()
                ArticleList()
                Spacer(Modifier.weight(1f, fill = true))
                AllRead()
            }
        }
    }
}

@Composable
fun Header() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Logo")
        }
        Text(text = "Menu")
    }
    Divider (
        color = Color.Black,
        modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
    )
}


@Composable
fun ArticleList() {
    Column  {
        Article()
        Article()
        Article()
        Article()
        Article()
        Article()
    }
}

@Composable
fun Article() {
    Box(
        modifier = Modifier
            .padding(15.dp)

    ) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sollicitudin, ligula quis fermentum pulvinar",
            textAlign = TextAlign.Center
        )
    }
    Divider (
        color = Color.Black,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun AllRead() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "All read")
        }
    }
}