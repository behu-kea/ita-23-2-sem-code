package com.example.note_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.note_app.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(
    note: Note? = null,
    onNoteChanged: (Note) -> Unit = {},
    onSaveNote: () -> Unit = {},
    backButtonPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Edit Note") },
                navigationIcon = {
                    IconButton(onClick = backButtonPressed) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            Row {
                FloatingActionButton(onClick = onSaveNote) {
                    Text(text = "Save note")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = note?.title ?: "Write your title here",
                onValueChange = {
                    if (note != null) {
                        onNoteChanged(note.copy(title = it))
                    }
                },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = note?.noteText ?: "Please write your text here",
                onValueChange = {
                    if (note != null) {
                        onNoteChanged(note.copy(noteText = it))
                    }
                },
                label = { Text("Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                textStyle = TextStyle(fontSize = 16.sp),
                maxLines = Int.MAX_VALUE // Make it expandable
            )
        }
    }
}
