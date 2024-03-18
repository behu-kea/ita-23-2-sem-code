package com.example.note_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.example.note_app.components.NoteDetailScreen
import com.example.note_app.components.OverviewScreen
import com.example.note_app.models.Note
import com.example.note_app.viewmodel.NotesViewModel

@Composable
fun AppNavigation(notesViewModel: NotesViewModel) {
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = "overview") {
        composable("overview") {
            OverviewScreen(
                notesViewModel.filteredNotes,
                notesText = notesViewModel.searchText,
                onNoteClicked = { note ->
                    navController.navigate("detail/${note.documentId}")
                },
                onAddNote = { navController.navigate("detail/new") },
                onSearchInput = {
                    notesViewModel.onSearchInput(it)
                }
            )
        }

        composable(
            "detail/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.StringType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId") ?: return@composable;
            val note: Note = notesViewModel.notes[0];
            NoteDetailScreen(note, onNoteChanged = {}, onSaveNote = {
                notesViewModel.saveNote(note);
                navController.popBackStack()
            },
                backButtonPressed = { navController.navigate("overview") }
            );
        }

        composable(
            "detail/new"
        ) {
            NoteDetailScreen(notesViewModel.newNote, onSaveNote = {
                notesViewModel.saveNote(notesViewModel.newNote);
                navController.popBackStack()
            }, onNoteChanged = {
                notesViewModel.newNote = it;
            }, backButtonPressed = {
                navController.popBackStack()
            });
        }
    }
}