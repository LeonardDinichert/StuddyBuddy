package com.studdybuddy.data

import com.google.firebase.firestore.FirebaseFirestore
import com.studdybuddy.model.StudySet
import kotlinx.coroutines.tasks.await

class StudySetManager(private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()) {
    private val collection = firestore.collection("studySets")

    suspend fun addSet(set: StudySet) {
        collection.add(set).await()
    }

    suspend fun getSets(): List<StudySet> {
        return collection.get().await().toObjects(StudySet::class.java)
    }
}
