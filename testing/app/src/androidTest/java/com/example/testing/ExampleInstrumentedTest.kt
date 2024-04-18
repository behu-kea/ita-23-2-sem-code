package com.example.testing

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get: Rule
    val rule = createComposeRule()

    @Test
    fun addNote() {

        rule.setContent {
            App()
        }

        rule.onNodeWithTag("name-textfield")
            .performTextInput("Benjamin")

        rule.onNodeWithText("emojify my name")
            .performClick()

        rule.onNodeWithTag("name-with-emoji")
            .assertTextEquals("Benjamin🎉")
    }
}