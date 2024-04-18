package com.example.skrald1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.skrald1.ui.theme.Skrald1Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

const val TAG = "asd";

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore

        setContent {
            var carColor by remember {
                mutableStateOf("")
            }
            Log.d("benjamin", "hej hej")
            var notes: MutableList<Note> by remember {
                mutableStateOf(mutableStateListOf())
            }
            Skrald1Theme {
                db.collection("cars")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            val note = document.toObject(Note::class.java)
                            Log.d(TAG, "${document.id} => ${note}")
                            Log.d(TAG, "${document.id} => ${note.title}")
                            carColor = note.title
                        }

                        notes = result.toObjects(Note::class.java)
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents.", exception)
                    }
                
                Text(text = carColor)

                LazyColumn {
                    items(notes) {note ->
                        Text(text = note.noteText)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Skrald1Theme {
        Greeting("Android")
    }
}