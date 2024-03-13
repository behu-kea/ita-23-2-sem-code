package com.example.note_app.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app.models.Note
import com.example.note_app.repositories.NotesRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.math.log

const val TAG = "NotesViewModel"

@SuppressLint("MutableCollectionMutableState")
class NotesViewModel : ViewModel() {
    val notesrepository: NotesRepository = NotesRepository();

    var newNote: Note by mutableStateOf(Note("", ""))
    var notes: MutableList<Note> by mutableStateOf(mutableStateListOf())

    var fetchedNote: Note? by mutableStateOf(Note("", ""))

    init {
        getNotes()
    }

    fun saveNote(note: Note) {
        notesrepository.saveNote(note);
        getNotes();
    }

    fun getNote(id: String) {
        Log.d(TAG, "getNote: before before")
        viewModelScope.launch {
            try {
                fetchedNote = notesrepository.getNote(id);
            } catch (error: Exception) {
                Log.d(TAG, "getNote: " + error)
            }
        }
    }

    private fun getNotes() {
        viewModelScope.launch {
            try {
                Log.d(TAG, "getNote: 1")
                notes = notesrepository.getNotes();
                Log.d(TAG, "getNote: 2")
            } catch (error: Exception) {
                Log.d(TAG, "getNotes: " + error)
            }
        }
    }
}