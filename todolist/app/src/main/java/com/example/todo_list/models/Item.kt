package com.example.todo_list.models

data class Item(
    val name: String,
    var isChecked: Boolean = false
) {
    override fun toString(): String {
        return "Item(name='$name', isChecked=$isChecked)"
    }
}