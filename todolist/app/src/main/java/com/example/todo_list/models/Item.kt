package com.example.todo_list.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

 class Item(
    val name: String,
    isChecked: Boolean = false
) {
    var isChecked: Boolean by mutableStateOf(isChecked)
    override fun toString(): String {
        return "Item(name='$name', isChecked=$isChecked)"
    }
}