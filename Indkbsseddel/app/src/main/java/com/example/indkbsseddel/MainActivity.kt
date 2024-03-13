package com.example.indkbsseddel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.indkbsseddel.models.GroceryItem
import com.example.indkbsseddel.ui.theme.IndkøbsseddelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndkøbsseddelTheme {
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
                        Text(
                            text = "Indkøbsseddel",
                            modifier = Modifier.background(MaterialTheme.colorScheme.primary)
                        )
                        Text(text = "Du har ${ideas.size} varer. ${checkedIdeas.size} er streget ud")
                        TextField(
                            value = ideaText,
                            onValueChange = { text ->
                                ideaText = text
                            }
                        )

                        Button(onClick = {
                            ideas.add(GroceryItem(ideaText));
                            ideaText = ""
                        })
                        {
                            Text(text = "Create new item")
                        }

                        LazyColumn {
                            items(items = ideas) { idea ->
                                com.example.indkbsseddel.GroceryItem(
                                    onCheckedChange = { idea.isChecked = !idea.isChecked; },
                                    onClick = { ideas.remove(idea) },
                                    idea = idea
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GroceryItem(onCheckedChange: (Boolean) -> Unit, onClick: () -> Unit, idea: GroceryItem) {
    Row {
        Text(
            text = idea.title, style = if (idea.isChecked) {
                TextStyle(textDecoration = TextDecoration.LineThrough)
            } else {
                TextStyle() // Default style or specify your own
            }
        )

        Checkbox(checked = idea.isChecked, onCheckedChange = onCheckedChange)
        Button(onClick = onClick) {
            Text(text = "Delete")
        }
    }
}
