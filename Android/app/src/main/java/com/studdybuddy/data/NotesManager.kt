package com.studdybuddy.data

import com.google.firebase.firestore.FirebaseFirestore
import com.studdybuddy.model.LearningNote
import kotlinx.coroutines.tasks.await

class NotesManager(private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()) {
    private val collection = firestore.collection("notes")

    suspend fun addNote(note: LearningNote) {
        collection.add(note).await()
    }

    suspend fun getNotes(): List<LearningNote> {
        return collection.get().await().toObjects(LearningNote::class.java)
    }

    // TODO: update and delete operations
}
