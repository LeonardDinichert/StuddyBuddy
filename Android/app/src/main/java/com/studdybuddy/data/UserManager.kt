package com.studdybuddy.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class UserManager(
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val storage: FirebaseStorage = FirebaseStorage.getInstance()
) {
    suspend fun getUser(uid: String): Map<String, Any>? {
        return firestore.collection("users").document(uid).get().await().data
    }

    suspend fun updateUser(uid: String, data: Map<String, Any>) {
        firestore.collection("users").document(uid).set(data, com.google.firebase.firestore.SetOptions.merge()).await()
    }

    // TODO: avatar upload, FCM token and streak logic
}
