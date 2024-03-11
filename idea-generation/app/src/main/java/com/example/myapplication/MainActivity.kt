package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.models.GroceryItem
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var ideas: MutableList<GroceryItem> by remember {
                        mutableStateOf(mutableStateListOf(GroceryItem("Milk")))
                    }

                    val checkedIdeas = ideas.filter { idea -> idea.isChecked }

                    var ideaText: String by remember {
                        mutableStateOf("")
                    }

                    Column {
                        Text(text = "Indkøbsseddel")
                        Text(text = "Du har ${ideas.size} varer. ${checkedIdeas.size} er streget ud")
                        TextField(
                            value = ideaText,
                            onValueChange = { text ->
                                ideaText = text
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                ideas.add(GroceryItem(ideaText));
                                ideaText = ""
                            })
                        )

                        LazyColumn {
                            items(items = ideas) { idea ->
                                Row {
                                    Text(
                                        text = idea.title, style = if (idea.isChecked) {
                                            TextStyle(textDecoration = TextDecoration.LineThrough)
                                        } else {
                                            TextStyle() // Default style or specify your own
                                        }
                                    )

                                    Checkbox(checked = idea.isChecked, onCheckedChange = {
                                        idea.isChecked = !idea.isChecked;
                                    })
                                    Button(onClick = { ideas.remove(idea) }) {
                                        Text(text = "Delete")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


