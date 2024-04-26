package com.example.testing.models

data class Note (var title: String, val description: String) {
    fun changeTitle(newTitle: String): Note {
        return this.copy(title = "iuoioui")
    }
}