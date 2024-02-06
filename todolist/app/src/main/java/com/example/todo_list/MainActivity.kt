package com.example.todo_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_list.models.Item
import com.example.todo_list.ui.theme.TodolistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var todoList: MutableList<Item> by remember {
                mutableStateOf(mutableStateListOf())
            }

            var checkListText by remember {
                mutableStateOf("")
            }

            Column {
                Text(text = stringResource(id = R.string.app_name), fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center)
                
                Spacer(modifier = Modifier.size(30.dp))
                
                Status(todoList)

                Row {
                    TextField(value = checkListText, onValueChange = {
                        checkListText = it;
                    })

                    Button(onClick = {
                        todoList.add(Item(checkListText))
                        checkListText = "";
                    }) {
                        Text(text = "Create todo")
                    }
                }

                LazyColumn() {
                    items(todoList) { item ->
                        TodoListItem(item = item,
                            onItemChecked = {
                                isChecked ->
                                    // This sucks. We cant just say item.isChecked = isChecked because Compose UI dont know that the list was changed!
                                    // Therefore we have to actually change the list in order for Compose UI to know the change
                                    item.isChecked = isChecked
                            },
                            onClicked = {
                                todoList.remove(item)
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun Status(todoList: MutableList<Item>) {
    val checkedItems = todoList.filter { it.isChecked }
    Text(text = stringResource(R.string.test, todoList.size, checkedItems.size))
}

@Composable
fun TodoListItem(item: Item, onItemChecked:(Boolean) -> Unit, onClicked: () -> Unit) {
    Row {
        Text(
            text = item.name,
            style = LocalTextStyle.current.copy(textDecoration = if (item.isChecked) TextDecoration.LineThrough else null)
        )

        Checkbox(checked = item.isChecked, onCheckedChange = onItemChecked)

        Button(onClick = onClicked) {
            Text(text = "Delete")
        }
    }
}