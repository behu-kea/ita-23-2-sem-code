package com.example.note_app.models

import com.google.firebase.firestore.DocumentId

data class Note(
    val title: String = "",
    val noteText: String = "",
    @DocumentId var documentId: String? = null
)