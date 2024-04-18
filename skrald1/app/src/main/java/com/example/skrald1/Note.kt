package com.example.skrald1

import com.google.firebase.firestore.DocumentId

data class Note(
    val noteText: String = "", // Make properties public
    val title: String = "", // Provide default values
    @DocumentId var documentId: String? = null
) {}