package com.example.note_app

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performTextInput
import com.example.note_app.navigation.AppNavigation
import com.example.note_app.viewmodel.NotesViewModel
import org.junit.Rule
import org.junit.Test

class UiTester {
    @get: Rule
    val rule = createComposeRule()

    val notesViewModel: NotesViewModel = NotesViewModel()

    @Test
    fun addNote() {
        rule.setContent { AppNavigation(notesViewModel); }

        rule.onNodeWithText("Add new note")
            .performClick()

        rule.onNodeWithText("Title")
            .performTextInput("olol")

        rule.onNodeWithText("Content")
            .performTextInput("olol1")

        rule.onNodeWithText("Save note")
            .performClick()

        rule.onNodeWithText("olol")
            .assertExists("The note with title 'olol' was not found in the list.")
    }
}