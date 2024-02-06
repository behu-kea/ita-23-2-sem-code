package com.example.note_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.note_app.ui.theme.NoteappTheme
import kotlin.math.log

data class Note (
    val id: Int = 0,
    val title: String = "",
    val noteText: String = ""
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val note1: Note = Note(1, "Title 1", "Text 1")
        val note2: Note = Note(2, "Title 2", "Text 2")
        val notes: List<Note> = listOf(note1, note2);

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "overview") {
                composable("overview") {
                    OverviewScreen(
                        notes,
                        onNoteClicked = {note ->
                            navController.navigate("detail/${note.id}")},
                        onAddNote = {navController.navigate("detail/new")}
                    )
                }
                composable(
                    "detail/{noteId}",
                    arguments = listOf(navArgument("noteId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val noteId = backStackEntry.arguments?.getInt("noteId") ?: return@composable;
                    Log.d("benjamin", noteId.toString());
                    val note: Note = notes[0];
                    Log.d("benjamin", note.noteText);
                    NoteDetailScreen(note, onNoteChanged = {}, onSaveNote = {});
                }
                composable(
                    "detail/new"
                ) {
                    NoteDetailScreen();
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen(notes: List<Note>, onNoteClicked: (Note) -> Unit, onAddNote: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Notes") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNote) {
                Icon(Icons.Filled.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TextField(
                value = "",
                onValueChange = { /* Handle search query change */ },
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

@Composable
fun NoteCard(note: Note, onNoteClicked: (Note) -> Unit) {
    Card(modifier = Modifier
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

@Composable
fun NoteItem(note: Note, onNoteClicked: (Note) -> Unit) {
    Text(text = note.title, modifier = Modifier.clickable { onNoteClicked(note) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(note: Note? = null, onNoteChanged: (Note) -> Unit = {}, onSaveNote: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Edit Note") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onSaveNote) {
                Text(text = "Save note")
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
                OutlinedTextField(
                    value = if (note != null ) {note.title} else { "Write your title here"},
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
                    value = if (note != null) {note.noteText} else { "Please write your text here"},
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
