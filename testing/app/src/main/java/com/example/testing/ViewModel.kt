package com.example.testing

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.testing.models.Note
val TAG = "hello";

class ViewModel {
    val notes: MutableList<Note> = mutableStateListOf();

    init {
        val note1 = Note("asd", "bom");
        notes.add(note1)
    }

    fun changeTitle(noteIndex: Int) {
        Log.d("hello", "Here")
        val noteToChange = notes[noteIndex];
        //val newNote = noteToChange.changeTitle("uuuu")
        //Log.d(TAG, newNote.toString())
        noteToChange.title = "jjj"
        notes[noteIndex] = noteToChange;
    }
}