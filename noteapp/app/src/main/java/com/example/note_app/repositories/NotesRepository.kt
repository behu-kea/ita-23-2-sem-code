package com.example.note_app.repositories

import android.util.Log
import com.example.note_app.Note
import com.example.note_app.TAG
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class NotesRepository(private val db: FirebaseFirestore) {
    fun getNotes() {
        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                val notes = mutableListOf<Note>();
                for (document in result) {
                    val note = document.toObject(Note::class.java).apply {
                        id = document.id // Set the document ID as the note's ID
                    };
                    notes.add(note)

                    Log.d(TAG, "asd" + note.toString());
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}