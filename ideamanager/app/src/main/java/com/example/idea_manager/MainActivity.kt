package com.example.idea_manager

import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.idea_manager.models.Idea


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                var ideaText by remember {
                    mutableStateOf("")
                }

                var ideas: MutableList<Idea> by remember {
                    mutableStateOf(mutableStateListOf())
                }

                Column {
                    Text(text = "Idea Manager")

                    TextField(value = ideaText, onValueChange = {
                        text -> ideaText = text;
                    })
                    
                    Button(onClick = {
                        Log.d("notesapp", "Click happened")
                        var idea = Idea(ideaText)
                        ideas.add(idea);
                        ideaText = ""
                    }) {
                        Text(text = "Add idea", modifier = Modifier.background(MaterialTheme.colorScheme.primary))
                    }

                    LazyColumn {
                        items(items = ideas) {
                            idea -> Text(text = idea.text)
                        }
                    }
                }
            }
        }
    }
}

