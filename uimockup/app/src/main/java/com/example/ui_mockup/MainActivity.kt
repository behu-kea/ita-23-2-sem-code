package com.example.ui_mockup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_mockup.ui.theme.UimockupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .background(Color.Red)) {
                        Text(text = "Dine lister hej")
                        Text(text = "4", modifier = Modifier
                            .background(Color.Blue), color = Color.White
                        )
                    }
                    Text(text = "Dine indkøbsopgaver",
                        modifier = Modifier
                        .weight(1f)
                            .background(Color.Yellow))
                }

                Row {
                    Text(text = "Weekend")
                    Box(modifier = Modifier.size(100.dp)) {
                        Icon(Icons.Filled.Create, contentDescription = "asd")
                    }
                }

                Text(text = "Frugt & grønt")
            }

        }
    }
}

