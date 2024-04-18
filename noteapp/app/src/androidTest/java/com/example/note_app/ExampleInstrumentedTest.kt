package com.example.note_app

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_app.navigation.AppNavigation
import com.example.note_app.viewmodel.NotesViewModel
import org.junit.Rule
import org.junit.Test

class UITest {
    @get: Rule
    val rule = createComposeRule()

    @Test
    fun addNote() {

        rule.setContent {
            val notesViewModel = viewModel<NotesViewModel>();
            AppNavigation(notesViewModel);
        }
    }
}