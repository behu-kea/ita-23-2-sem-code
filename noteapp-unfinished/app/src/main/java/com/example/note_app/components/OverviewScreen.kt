package com.example.note_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.note_app.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen(
    notes: List<Note>,
    notesText: String,
    onNoteClicked: (Note) -> Unit,
    onAddNote: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notes") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Text(text = "Add new note")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TextField(
                value = notesText,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Search notes") },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                },
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))
            LazyColumn {
                items(notes) { note ->
                    NoteCard(note, onNoteClicked)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}