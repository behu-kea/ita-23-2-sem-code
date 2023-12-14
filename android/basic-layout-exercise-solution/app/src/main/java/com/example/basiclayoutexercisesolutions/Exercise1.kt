package com.example.basiclayoutexercisesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Exercise1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier =
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Velkommen til min app",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(16.dp)
                );
                Column (
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                    ) {
                        Text(text = "Knap 1")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                    ) {
                        Text(text = "Knap 2")
                    }
                }
            }
        }
    }
}