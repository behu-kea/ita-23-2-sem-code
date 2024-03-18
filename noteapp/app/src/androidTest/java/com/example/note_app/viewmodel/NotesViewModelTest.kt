package com.example.note_app.viewmodel

import android.util.Log
import com.example.note_app.viewmodel.NotesViewModel
import org.junit.Before

import org.junit.Test

class NotesViewModelTest {
    private var notesViewModel: NotesViewModel = NotesViewModel();

    @Before
    fun setupViewModel() {
        notesViewModel = NotesViewModel()
    }

    @Test
    fun testSearch() {
        Log.d("hej", "!!!!!!!!!")
        notesViewModel.onSearchInput("ingeborg");
        val notes = notesViewModel.notes;
        assert("asd" == "asd");
        /*
        Log.d("hej", notesViewModel.notes[0].toString())

        assert(notesViewModel.notes[0].title.contains("ingeborg"))

         */
    }
}