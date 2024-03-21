package com.example.note_app.repositories

import android.util.Log

import com.example.note_app.TAG
import com.example.note_app.models.Note
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

class NotesRepository() {
    val db = Firebase.firestore;
    suspend fun getNotes(): MutableList<Note> = db.collection("notes")
        .get()
        .await()
        .toObjects(Note::class.java)

    suspend fun getNote(id: String): Note? = db.collection("notes").document(id).get().await()
        .toObject(Note::class.java)

    fun saveNote(note: Note) {
        // Add a new document with a generated ID
        db.collection("notes")
            .add(note)
            .addOnSuccessListener { documentReference ->
                Log.d("benjamin", "DocumentSnapshot added with ID: $documentReference")
            }
            .addOnFailureListener { e ->
                Log.w("benjamin", "Error adding document", e)
            }
    }

    fun deleteNote(note: Note) {
        // Add a new document with a generated ID
        note.documentId?.let {
            db.collection("notes")
                .document(it)
                .delete()
                .addOnSuccessListener { documentReference ->
                    Log.d("benjamin", "DocumentSnapshot added with ID: $documentReference")
                }
                .addOnFailureListener { e ->
                    Log.w("benjamin", "Error adding document", e)
                }
        }
    }
}