package com.example.note_app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.note_app.models.Note

@Composable
fun NoteCard(note: Note, onNoteClicked: (Note) -> Unit) {
    Card(modifier = Modifier
        .testTag("myButtonTag")
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .clickable { onNoteClicked(note) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = note.title, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = note.noteText, style = MaterialTheme.typography.bodyLarge)
        }
    }
}